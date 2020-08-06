package com.example.movepng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgDVSC, imgChuot, imgLogo;
    Animation runingChupt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgDVSC = findViewById(R.id.imgDVSC);
        imgLogo = findViewById(R.id.imgLogo);
        imgChuot = findViewById(R.id.imgChuot);
        runingChupt = AnimationUtils.loadAnimation(MainActivity.this,R.anim.logo);
        imgChuot.startAnimation(runingChupt);

        final AnimationDrawable runingcat = (AnimationDrawable) imgDVSC.getDrawable();
        runingcat.start();
        imgChuot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runingChupt = AnimationUtils.loadAnimation(MainActivity.this, R.anim.chuot);
                imgChuot.startAnimation(runingChupt);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(intent);
                    }
                },3000);






            }
        });


//        final Animation runingLogo = AnimationUtils.loadAnimation(MainActivity.this,R.anim.logo);
//        imgChuot.startAnimation(runingLogo);


    }

}
