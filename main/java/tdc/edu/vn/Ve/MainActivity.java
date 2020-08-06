package tdc.edu.vn.Ve;


import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SensorManager sensorManager;
    Sensor sensor = null;
    private DevicePolicyManager devicePolicyManager;
    private ComponentName componentName;

    private SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            float x = values[0];
            float y = values[1];
            float z = values[2];
            float acceleSquareRoot = (x*x + y*y + z*z)/(SensorManager.GRAVITY_EARTH*SensorManager.GRAVITY_EARTH);


            if (acceleSquareRoot > 2){
                boolean active = devicePolicyManager.isAdminActive(componentName);
                if (active){
                    devicePolicyManager.lockNow();
                }
                else {
                    Toast.makeText(MainActivity.this,"This admin permission is not activated",Toast.LENGTH_SHORT).show();
                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        devicePolicyManager = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
        componentName = new ComponentName(this,MyAdmin.class);

        setContentView(R.layout.activity_main);

        //for register admin pormission for app
        Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,componentName);
        startActivity(intent);

        //for read sensor data
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sensor != null){
            sensorManager.registerListener(sensorEventListener,sensor,SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            Toast.makeText(MainActivity.this,"This phone has not sensor",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        if (sensor != null){
            sensorManager.unregisterListener(sensorEventListener);
        }else {
            Toast.makeText(MainActivity.this,"This phone has not sensor",Toast.LENGTH_SHORT).show();
        }
        super.onPause();
    }

}
