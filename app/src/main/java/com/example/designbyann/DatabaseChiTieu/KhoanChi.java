package com.example.designbyann.DatabaseChiTieu;

public class KhoanChi {
    private String maKhoanChi;
    private String tenKhoanChi;
    private Double soTien;
    private String ngayChi;

    public KhoanChi(){

    }

    public KhoanChi(String maKhoanChi, String tenKhoanChi, double soTien, String ngayChi) {
        this.maKhoanChi = maKhoanChi;
        this.tenKhoanChi = tenKhoanChi;
        this.soTien = soTien;
        this.ngayChi = ngayChi;
    }

    public String getMaKhoanChi() {
        return maKhoanChi;
    }

    public void setMaKhoanChi(String maKhoanChi) {
        this.maKhoanChi = maKhoanChi;
    }

    public String getTenKhoanChi() {
        return tenKhoanChi;
    }

    public void setTenKhoanChi(String tenKhoanChi) {
        this.tenKhoanChi = tenKhoanChi;
    }

    public Double getSoTien() {
        return soTien;
    }

    public void setSoTien(Double soTien) {
        this.soTien = soTien;
    }

    public String getNgayChi() {
        return ngayChi;
    }

    public void setNgayChi(String ngayChi) {
        this.ngayChi = ngayChi;
    }

    @Override
    public String toString() {
        return "Mã khoản chi"+"-"+"Tên khoản chi" + tenKhoanChi + "-" +
                "Số tiền" +  soTien + "-" +

                "Ngày chi" + ngayChi ;
    }
}
