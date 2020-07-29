package com.example.doan.GiaoDien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan.DataBase.DBDichVu;
import com.example.doan.Model.DichVu;
import com.example.doan.R;

import java.util.ArrayList;

public class ChiTietDichVu extends AppCompatActivity {

    EditText txtSoLuongChiTiet,txtGiaChiTiet;

    TextView txtTenDVChiTiet;
    ImageView imgHinhChiTiet;
    ArrayList<DichVu> data_DV = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setConTrol();
        setEvent();

        setContentView(R.layout.activity_chi_tiet_dich_vu);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }


    private void setEvent() {
//        String ma= getIntent().getExtras().getString("ma");
//        DBDichVu dbDichVu = new DBDichVu(this);
//        data_DV = dbDichVu.LayDL(ma);
//        txtTenDVChiTiet.setText(data_DV.get(0).getTenDV());
//        txtSoLuongChiTiet.setText(data_DV.get(0).getSoLuong());
//        txtGiaChiTiet.setText(data_DV.get(0).getDonGia());
//        txtTenDVChiTiet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

//        imgHinhChiTiet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                String ma= getIntent().getExtras().getString("ma");
////                Toast.makeText(getApplication(),ma,Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private void setConTrol() {
        txtSoLuongChiTiet = findViewById(R.id.txtSoluongDichvu);
        txtGiaChiTiet = findViewById(R.id.txtGia);
        txtTenDVChiTiet = findViewById(R.id.tvTenDV);
        imgHinhChiTiet = findViewById(R.id.imgHinhChiTiet);
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
