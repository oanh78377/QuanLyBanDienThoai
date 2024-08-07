/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlbandienthoai.DAO;

import com.qlbandienthoai.entity.KhachHang;
import com.qlbandienthoai.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class KhachHangDAO {

    public void insert(KhachHang model) {
        String insert = String.format("INSERT INTO KhachHang(MaKhachHang, TenKhachHang, SDT, Diachi, GioiTInh,NgaySinh, SoLanMua) VALUES(?, ?, ?, ?, ?, ?, ?)");
        XJdbc.update(insert,
                model.getCode(),
                model.getName(),
                model.getPhone(),
                model.getAdress(),
                model.getGender(),
                model.getBrith(),
                model.getNumber()
        );
    }

    public void update(KhachHang model) {
        String sql = "UPDATE KHACHHANG SET TenKhachHang=?, SDT=?, Diachi=?, GioiTinh=?, NgaySinh=?, SoLanMua=? WHERE MaKhachHang=?";
        XJdbc.update(sql,
                model.getName(),
                model.getPhone(),
                model.getAdress(),
                model.getGender(),
                model.getBrith(),
                model.getNumber(),
                model.getCode());

    }

    public void delete(String MaKhachHang) {
        String sql = "DELETE FROM KHACHHANG WHERE MaKhachHang=?";
        XJdbc.update(sql, MaKhachHang);
    }

    public KhachHang selectById(String MaKhachHang) {
        String sql = "SELECT * FROM KHACHHANG WHERE MaKhachHang=?";
        List<KhachHang> list = this.selectBySql(sql, MaKhachHang);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<KhachHang> selectAll() {
        String sql = "SELECT * FROM KhachHang";
        return this.selectBySql(sql);
    }

    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    KhachHang entity = new KhachHang();
                    entity.setCode(rs.getString("MaKhachHang"));
                    entity.setName(rs.getString("TenKhachHang"));
                    entity.setPhone(rs.getString("SDT"));
                    entity.setAdress(rs.getString("Diachi"));
                    entity.setGender(rs.getInt("GioiTInh"));
                    entity.setBrith(rs.getDate("NgaySinh"));
                    entity.setNumber(rs.getInt("SoLanMua"));
                    list.add(entity);
                }
            } finally {
                if (rs != null) {
                    rs.getStatement().getConnection().close();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<KhachHang> selectByName(String keyword) {
        String sql = "SELECT * FROM KhachHang WHERE TenKhachHang LIKE ?";
        return selectBySql(sql, "%" + keyword + "%");
    }
}
