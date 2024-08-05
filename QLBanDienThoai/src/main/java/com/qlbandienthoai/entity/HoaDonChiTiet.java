/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlbandienthoai.entity;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HoaDonChiTiet {
    private String MaHoaDonChiTiet;
    private String MaSanPham;
    private String MaHoaDon;
    private String TrangThai;
    private int SoLuong;
    private int Giaban;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String MaHoaDonChiTiet, String MaSanPham, String MaHoaDon, String TrangThai, int SoLuong, int Giaban) {
        this.MaHoaDonChiTiet = MaHoaDonChiTiet;
        this.MaSanPham = MaSanPham;
        this.MaHoaDon = MaHoaDon;
        this.TrangThai = TrangThai;
        this.SoLuong = SoLuong;
        this.Giaban = Giaban;
    }

    public String getMaHoaDonChiTiet() {
        return MaHoaDonChiTiet;
    }

    public void setMaHoaDonChiTiet(String MaHoaDonChiTiet) {
        this.MaHoaDonChiTiet = MaHoaDonChiTiet;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getGiaban() {
        return Giaban;
    }

    public void setGiaban(int Giaban) {
        this.Giaban = Giaban;
    }

    public List<HoaDonChiTiet> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getNgayMua() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
