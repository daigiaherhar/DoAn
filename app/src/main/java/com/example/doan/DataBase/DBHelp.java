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
        String sql = "create table khachhang(ma text ,ten text,ngaySinh text,diaChi text,gioiTinh text)";
        String sql1 = "create table dichvu(madv text,tendv text,dongia float,soluong int,hinhanh text)";
        String sql2 = "create table phatsinh(sophieu INTEGER PRIMARY KEY AUTOINCREMENT,ngaylap text,makh text)";
        String sql3 = "create table phatsinhchitiet(sophieu INTEGER PRIMARY KEY AUTOINCREMENT,madv text,soLuong int,sotien int)";
//        String sql="create table SinhVien(hoten text, gioitinh Text , khoa text )";

        db.execSQL(sql);
        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        int data;
    }
}