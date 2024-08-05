/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlbandienthoai.entity;

/**
 *
 * @author ADMIN
 */
public class HangDienThoai {
    private String maHangDienThoai;
    private String tenHangDienThoai;
   

    @Override
    public String toString() {
        return this.tenHangDienThoai;
    }

    public String getMaHangDienThoai() {
        return maHangDienThoai;
    }

    public void setMaHangDienThoai(String maHangDienThoai) {
        this.maHangDienThoai = maHangDienThoai;
    }

    public String getTenHangDienThoai() {
        return tenHangDienThoai;
    }

    public void setTenHangDienThoai(String tenHangDienThoai) {
        this.tenHangDienThoai = tenHangDienThoai;
    }
    
    
}
