package com.example.doan.Model;

public class PhieuThu {
    String soPhieu;
    String ngayLap;
    String maKH;

    public String getSoPhieu() {
        return soPhieu;
    }

    public void setSoPhieu(String soPhieu) {
        this.soPhieu = soPhieu;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public PhieuThu(String soPhieu, String ngayLap, String maKH) {
        this.soPhieu = soPhieu;
        this.ngayLap = ngayLap;
        this.maKH = maKH;
    }
}
