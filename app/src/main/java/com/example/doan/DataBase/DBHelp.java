package com.example.doan.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelp  extends SQLiteOpenHelper {
    public DBHelp( Context context) {
        super(context, "DichVuSuaChua", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table khachhang(ma text,ten text,ngaySinh text,diaChi text,gioiTinh text)";
        String sql1 = "create table dichvu(madv text,tendv text,dongia float,soluong int,hinhanh text)";
//        String sql="create table SinhVien(hoten text, gioitinh Text , khoa text )";

        db.execSQL(sql);
        db.execSQL(sql1);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        int data;
    }
}