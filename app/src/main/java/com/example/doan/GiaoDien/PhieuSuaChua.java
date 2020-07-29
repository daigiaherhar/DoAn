package com.example.doan.GiaoDien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan.Adapter.DichVuHightAdapter;
import com.example.doan.DataBase.DBPhatSinh;
import com.example.doan.Model.PhatSinh;
import com.example.doan.R;

import java.util.ArrayList;

public class PhieuSuaChua extends AppCompatActivity {
    Button btnInHoaDon, btnTk;
    EditText txtMaKHPhieuSuaChua;
    ListView lvPhatSinh, lvPhatSinhChiTiet;
    ArrayList<PhatSinh> dataPhatSinh = new ArrayList<>();
    ArrayAdapter adapter_phatsinh;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phieu_sua_chua);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        setControl();
        setEvent();
    }

    private void setEvent() {
//        try {
//            DBPhatSinh dbPhatSinh = new DBPhatSinh(this);
//            dataPhatSinh = dbPhatSinh.LayDL();
//            adapter_phatsinh = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dataPhatSinh);
//
//            lvPhatSinh.setAdapter(adapter_phatsinh);
//
//        } catch (Exception e) {
//
//        }
        btnInHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PhieuSuaChua.this, InHoaDon.class);
                startActivity(intent);
            }
        });
        btnTk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

    private void setControl() {
        btnInHoaDon = findViewById(R.id.btnInHoaDon);
        lvPhatSinh = findViewById(R.id.lvPhatSinh);
        lvPhatSinhChiTiet = findViewById(R.id.lvPhatSinhChiTiet);
        txtMaKHPhieuSuaChua = findViewById(R.id.txtMaKHPhieuSuaChua);
        btnTk = findViewById(R.id.btntk);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_phieusuachua, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menuTimKiem:
                if (txtMaKHPhieuSuaChua.length() == 0) {
                    break;
                } else {
                    DBPhatSinh dbKhachHang = new DBPhatSinh(getApplication());
                    String key = txtMaKHPhieuSuaChua.getText() + "";
                    //ArrayList<KhachHang> khachHangs = new ArrayList<>();
                    dataPhatSinh = dbKhachHang.TimKiem(txtMaKHPhieuSuaChua.getText() + "");
                    Toast.makeText(getApplication(), key, Toast.LENGTH_SHORT).show();
//                    for (KhachHang asb :
//                            dataKh) {
//                            if(asb.getTen().equals(txtTimKiem.getText()))
//                            {
//                                dataKh.add(asb);
//                            }
//                    }
                    adapter_phatsinh = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dataPhatSinh);
                    // dataKh.sort(new TenSort());
                    lvPhatSinh.setAdapter(adapter_phatsinh);
                    adapter_phatsinh.notifyDataSetChanged();

                }

//                try {
//                    String key = txtMaKHPhieuSuaChua.getText() + "";
//                    Toast.makeText(getApplication(), key, Toast.LENGTH_SHORT).show();
//
//                    switch (key) {
//                        case "4":
//                        DBPhatSinh dbPhatSinh = new DBPhatSinh(this);
//                        dataPhatSinh = dbPhatSinh.LayDL();
//                        adapter_phatsinh = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dataPhatSinh);
//                        lvPhatSinh.setAdapter(adapter_phatsinh);
//                        break;
//                    }
//
//
//                } catch (Exception e) {
//
//                }

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    int TimKiem(ArrayList<PhatSinh> arr, String key) {
        for (int i = 0; i < dataPhatSinh.size(); i++) {
            if (arr.get(i).getMaKH() == key) {
                return i;
            }
        }
        return -1;
    }
}
