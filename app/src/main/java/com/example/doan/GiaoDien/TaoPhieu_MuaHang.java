package com.example.doan.GiaoDien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.doan.Adapter.DichVuHightAdapter;
import com.example.doan.DataBase.DBDichVu;
import com.example.doan.DataBase.DBPhatSinh;
import com.example.doan.Model.DichVu;
import com.example.doan.Model.PhatSinh;
import com.example.doan.R;

import java.util.ArrayList;

public class TaoPhieu_MuaHang extends AppCompatActivity {
    ListView lvLuaChonDichVu;
    ArrayList<DichVu> arrDV = new ArrayList<>();
    ArrayList<PhatSinh> arrPS = new ArrayList<>();
    ArrayAdapter adapterDV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tao_phieu__mua_hang);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setControl();
        setEvent();
    }

    private void setControl() {
        lvLuaChonDichVu = findViewById(R.id.lvLuaChonDichVu);
    }

    private void setEvent() {
        try {
            DBDichVu dbDichVu = new DBDichVu(getApplication());
            arrDV = dbDichVu.LayDL();

            adapterDV = new DichVuHightAdapter(this, R.layout.dichvu_adapter_hight, arrDV);
            lvLuaChonDichVu.setAdapter(adapterDV);

        } catch (Exception e) {

        }
        lvLuaChonDichVu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               int soPhieu = MainActivity.soPhieuPhatSinh;
               Toast.makeText(getApplication(),soPhieu+"",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
