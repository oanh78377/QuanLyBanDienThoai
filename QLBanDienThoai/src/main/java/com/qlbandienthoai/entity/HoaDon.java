/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlbandienthoai.entity;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class HoaDon {
     private String MaHoaDon;
    private String MaKhachHang;
    private String MaNhanVien;
    private String TrangThai;
    private int GiaBan;
   private java.util.Date brith = new java.util.Date();

    public HoaDon() {
    }

    public HoaDon(String MaHoaDon, String MaKhachHang, String MaNhanVien, String TrangThai, int GiaBan) {
        this.MaHoaDon = MaHoaDon;
        this.MaKhachHang = MaKhachHang;
        this.MaNhanVien = MaNhanVien;
        this.TrangThai = TrangThai;
        this.GiaBan = GiaBan;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(int GiaBan) {
        this.GiaBan = GiaBan;
    }

    public java.util.Date getBrith() {
        return brith;
    }

    public void setBrith(java.util.Date brith) {
        this.brith = brith;
    }

   
    
}
