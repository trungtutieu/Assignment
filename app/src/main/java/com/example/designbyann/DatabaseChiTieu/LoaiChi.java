package com.example.designbyann.DatabaseChiTieu;

public class LoaiChi {
    private String maLoaiChi;
    private String tenLoaiChi;

    public LoaiChi(String maKC, String tenKC, Double soTien, String ngayChi) {

    }

    public LoaiChi(String maLoaiChi, String tenLoaiChi) {
        this.maLoaiChi = maLoaiChi;
        this.tenLoaiChi = tenLoaiChi;
    }

    public String getMaLoaiChi() {
        return maLoaiChi;
    }

    public void setMaLoaiChi(String maLoaiChi) {
        this.maLoaiChi = maLoaiChi;
    }

    public String getTenLoaiChi() {
        return tenLoaiChi;
    }

    public void setTenLoaiChi(String tenLoaiChi) {
        this.tenLoaiChi = tenLoaiChi;
    }

    @Override
    public String toString() {
        return this.maLoaiChi + "-" + this.tenLoaiChi;
    }
}
