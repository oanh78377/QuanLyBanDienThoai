/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlbandienthoai.DAO;

import com.qlbandienthoai.entity.NhanVien;
import com.qlbandienthoai.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author ADMIN
 */
public class NhanVienDAO extends EduSysDAO<NhanVien, String>{

    
    public void insert(NhanVien model) {
        String sql="INSERT INTO NHANVIEN (MaNhanVien, HoTen, MatKhau, Email, GioiTinh, VaiTro) VALUES (?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql, 
                model.getMaNhanVien(), 
                model.getHoTen(), 
                model.getMatKhau(), 
                model.getEmail(), 
                model.getGioiTinh(),
                model.getVaiTro());
    }

    
    public void update(NhanVien model) {
        String sql="UPDATE NHANVIEN SET HoTen=?, MatKhau=?, Email=?, GioiTinh=?, VaiTro=? WHERE MaNhanVien=?";
        XJdbc.update(sql, 
                model.getHoTen(),
                model.getMatKhau(),
                model.getEmail(),
                model.getGioiTinh(),
                model.getVaiTro(),
                model.getMaNhanVien());
    
    }

    
    public void delete(String MaNhanVien) {
        String sql="DELETE FROM NHANVIEN WHERE MaNhanVien=?";
        XJdbc.update(sql, MaNhanVien);
    }

    
    public NhanVien selectById(String MaNhanVien) {
        String sql="SELECT * FROM NHANVIEN WHERE MaNhanVien=?";
        List<NhanVien> list = this.selectBySql(sql, MaNhanVien);
        return list.size() > 0 ? list.get(0) : null;
    }

    
    public List<NhanVien> selectAll() {
        String sql="SELECT * FROM NhanVien";
        return this.selectBySql(sql);
    }

   
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    NhanVien entity=new NhanVien();
                    entity.setMaNhanVien(rs.getString("MaNhanVien"));
                    entity.setHoTen(rs.getString("HoTen"));
                    entity.setMatKhau(rs.getString("MatKhau"));
                    entity.setEmail(rs.getString("Email"));
                    entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                    entity.setVaiTro(rs.getBoolean("VaiTro"));
                    list.add(entity);
                }
            } 
            finally{
                if(rs != null)
                    rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }

   
}
