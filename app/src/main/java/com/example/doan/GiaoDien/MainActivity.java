package com.example.doan.GiaoDien;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;

import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan.Adapter.DichVuAdapter;
import com.example.doan.Adapter.DichVuHightAdapter;
import com.example.doan.Adapter.ItemNavigationAdapter;
import com.example.doan.DataBase.DBDichVu;
import com.example.doan.DataBase.DBKhachHang;
import com.example.doan.DataBase.DBPhatSinh;
import com.example.doan.Model.ItemNavigation;
import com.example.doan.Model.PhatSinh;
import com.example.doan.Model.PhatSinhChiTiet;
import com.example.doan.R;
import com.example.doan.ThuVien.MyAdmin;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button btnThem;
    ListView listNavigation, lvDichVuHight;
    TextView txtMaKH, txtTenKH, txtNgaySinh, txtDiaChi;
    FrameLayout mainLayout;

    ArrayList<com.example.doan.Model.DichVu> arrDV = new ArrayList<>();
    ArrayList<com.example.doan.Model.PhatSinh> arrPS = new ArrayList<>();
    ArrayList<com.example.doan.Model.KhachHang> arrKH = new ArrayList<>();
    ArrayAdapter adapterDV;


    ArrayList<ItemNavigation> navigationNames = new ArrayList<>();
    ArrayAdapter adapter_navigation;

    int navigationID = 0;
    int loi = 0;
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle drawerToggle;
    public static int soPhieuPhatSinh = 0;
    public static String maKH = "";
    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.keo_navagation); // lưu ý ở đây
        FrameLayout mainLayout = findViewById(R.id.drawContainer);
        getLayoutInflater().inflate(R.layout.activity_main, mainLayout);

        setControl();
        setToggleDraw();

        setEvent();

    }

    private void setEvent() {

        dienThongTinNavigation();
        //dien thong tin navigation
        try {
            DBDichVu dbDichVu = new DBDichVu(getApplication());
            arrDV = dbDichVu.LayDL();
            adapterDV = new DichVuAdapter(this, R.layout.dichvu_adapter, arrDV);
            lvDichVuHight.setAdapter(adapterDV);


        } catch (Exception e) {

        }


        listNavigation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                navigationID = position;
                if (navigationID == 0) {
                    drawerLayout.closeDrawer(listNavigation);
                }
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

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
//                String date1 = df.format(Calendar.getInstance().getTime());
//                Toast.makeText(getApplication(), date1,Toast.LENGTH_SHORT).show();
                if(txtMaKH.getText().length() == 0)
                {
                    Toast.makeText(getApplication(), "Nhập mã khách hàng!", Toast.LENGTH_SHORT).show();
                }
                else if(loi == 0) {
                    try {
                        DBKhachHang dbKhachHang = new DBKhachHang(getApplication());
                        String key = txtMaKH.getText() + "";
                        arrKH = dbKhachHang.TimKiemMa(txtMaKH.getText() + "");

                        loi = 1;
                    } catch (Exception e) {

                        Toast.makeText(getApplication(), "Không tìm thấy!", Toast.LENGTH_SHORT).show();
                    }
                }
                if(loi == 1)
                {
                    loi = 0;
                    DBPhatSinh dbPhatSinh = new DBPhatSinh(getApplication());
                    PhatSinh phatSinh = getPhatSinh();
                    dbPhatSinh.them(phatSinh);

                    //create public soPhieu send layout_TaoPhieu_MuaHang
                    arrPS = dbPhatSinh.LayDL();
                    soPhieuPhatSinh = arrPS.size();
                    maKH = txtMaKH.getText().toString();
                    Intent intent = new Intent(MainActivity.this, TaoPhieu_MuaHang.class);
                    startActivity(intent);
                }

          }
        });



    }

    private PhatSinh getPhatSinh() {
        PhatSinh phatSinh = new PhatSinh();

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String date = df.format(Calendar.getInstance().getTime());

        phatSinh.setNgayLap(date);


        phatSinh.setMaKH(txtMaKH.getText().toString());
        return phatSinh;
    }

    private void dienThongTinNavigation() {

        navigationNames.add(new ItemNavigation("Trang chủ", R.drawable.trangchu));
        navigationNames.add(new ItemNavigation("Danh sách khách hàng", R.drawable.danhsachkh));
        navigationNames.add(new ItemNavigation("Phiếu sửa chữa", R.drawable.showrecycler));
        navigationNames.add(new ItemNavigation("Thêm khách hàng", R.drawable.themkhachhang));
        navigationNames.add(new ItemNavigation("Thêm dịch vụ", R.drawable.themdichvu));


        adapter_navigation = new ItemNavigationAdapter(this, R.layout.navigation, navigationNames);
        listNavigation.setAdapter(adapter_navigation);
        registerForContextMenu(listNavigation);
    }


    private void setControl() {
//        SPChuot = findViewById(R.id.SPChuot);
//        SPCaiWin = findViewById(R.id.SPCaiWin);
//        SPMain = findViewById(R.id.SPMain);
//        SPCPU = findViewById(R.id.SPCPU);
//        SPBanPhim = findViewById(R.id.SPBanPhim);
        btnThem = findViewById(R.id.btnThem);

        lvDichVuHight = findViewById(R.id.lvDichVuHight);
        txtMaKH = findViewById(R.id.txtMaKH);
        txtDiaChi = findViewById(R.id.txtDiaChi);
        txtNgaySinh = findViewById(R.id.txtNgaySinh);
        txtTenKH = findViewById(R.id.txtTenKH);


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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_phieusuachua, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menuTimKiem:
                if (txtMaKH.getText().length() == 0) {
                    break;
                } else {

                    try {
                        DBKhachHang dbKhachHang = new DBKhachHang(getApplication());
                        String key = txtMaKH.getText() + "";
                        arrKH = dbKhachHang.TimKiemMa(txtMaKH.getText() + "");

                        Toast.makeText(getApplication(), key, Toast.LENGTH_SHORT).show();
                        txtTenKH.setText(arrKH.get(0).getTen());
                        txtNgaySinh.setText(arrKH.get(0).getNgaySinh());
                        txtDiaChi.setText(arrKH.get(0).getDiaChi());

                    } catch (Exception e) {

                        Toast.makeText(getApplication(), "Không tìm thấy!", Toast.LENGTH_SHORT).show();
                    }

                }

                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
