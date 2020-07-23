package com.example.doan.GiaoDien;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;

import android.widget.ListView;
import android.widget.Spinner;

import com.example.doan.Adapter.ItemNavigationAdapter;
import com.example.doan.Model.ItemNavigation;
import com.example.doan.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner SPChuot, SPCaiWin, SPMain, SPCPU, SPBanPhim;
    ListView listNavigation;
    FrameLayout mainLayout;

    ArrayList<String> arraySoLuong = new ArrayList<>();
    ArrayList<com.example.doan.Model.DichVu> arrayDichVu = new ArrayList<>();

    ArrayAdapter adapter_soLuong;

    static Intent intent;
    ArrayList<ItemNavigation> navigationNames = new ArrayList<>();
    ArrayAdapter adapter_navigation;

    int navigationID = 0;
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keo_navagation); // lưu ý ở đây


        FrameLayout mainLayout = findViewById(R.id.drawContainer);
        getLayoutInflater().inflate(R.layout.activity_main, mainLayout);
//        final DrawerLayout drawerLayout = findViewById(R.id.drawLayout);

        setControl();
        setToggleDraw();

        setEvent();

    }


    private void setEvent() {
        khoiTaoGiaTri();
        dienThongTinNavigation();
        //dien thong tin navigation


        //dien so luong
        adapter_soLuong = new ArrayAdapter(this, android.R.layout.simple_spinner_item, arraySoLuong);
        SPChuot.setAdapter(adapter_soLuong);
        SPBanPhim.setAdapter(adapter_soLuong);
        SPCaiWin.setAdapter(adapter_soLuong);
        SPMain.setAdapter(adapter_soLuong);
        SPCPU.setAdapter(adapter_soLuong);

        listNavigation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                navigationID = position;
                if (navigationID == 1) {

                    Intent intent = new Intent(MainActivity.this, DanhSachKH.class);
                    startActivity(intent);
                    drawerLayout.closeDrawer(listNavigation);
                }
                if (navigationID == 2) {

                    Intent intent = new Intent(MainActivity.this, PhieuSuaChua.class);
                    startActivity(intent);
                    drawerLayout.closeDrawer(listNavigation);
                }
                if (navigationID == 3) {

                    Intent intent = new Intent(MainActivity.this, KhachHang.class);
                    startActivity(intent);

                    drawerLayout.closeDrawer(listNavigation);

                }
                if (navigationID == 4) {

                    Intent intent = new Intent(MainActivity.this, DichVu.class);
                    startActivity(intent);

                    drawerLayout.closeDrawer(listNavigation);

                }
            }
        });

    }

    private void dienThongTinNavigation() {

        navigationNames.add(new ItemNavigation("Trang chủ",R.drawable.trangchu));
        navigationNames.add(new ItemNavigation("Danh sách khách hàng",R.drawable.danhsachkh));
        navigationNames.add(new ItemNavigation("Phiếu sửa chữa",R.drawable.showrecycler));
        navigationNames.add(new ItemNavigation("Thêm khách hàng",R.drawable.themkhachhang));
        navigationNames.add(new ItemNavigation("Thêm dịch vụ",R.drawable.themdichvu));


        adapter_navigation = new ItemNavigationAdapter(this,R.layout.navigation, navigationNames);
        listNavigation.setAdapter(adapter_navigation);
        registerForContextMenu(listNavigation);
    }

    private void khoiTaoGiaTri() {
        //so luong combobox
        for (int i = 1; i < 11; i++) {
            arraySoLuong.add(i + "");
        }

    }

    private void setControl() {
        SPChuot = findViewById(R.id.SPChuot);
        SPCaiWin = findViewById(R.id.SPCaiWin);
        SPMain = findViewById(R.id.SPMain);
        SPCPU = findViewById(R.id.SPCPU);
        SPBanPhim = findViewById(R.id.SPBanPhim);

        listNavigation = findViewById(R.id.draw);
        drawerLayout = findViewById(R.id.drawLayout);
        mainLayout = findViewById(R.id.drawContainer);
    }

    private void setToggleDraw() {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);

        drawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.btnSua, R.string.btnThem) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
