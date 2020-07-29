package com.example.doan.Model;

public class PhatSinhChiTiet {
    String soPhieu;
    String maDV;
    int soLuong;

    public String getSoPhieu() {
        return soPhieu;
    }

    public void setSoPhieu(String soPhieu) {
        this.soPhieu = soPhieu;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public PhatSinhChiTiet(String soPhieu, String maDV, int soLuong) {
        this.soPhieu = soPhieu;
        this.maDV = maDV;
        this.soLuong = soLuong;
    }
    public PhatSinhChiTiet() {

    }
}
