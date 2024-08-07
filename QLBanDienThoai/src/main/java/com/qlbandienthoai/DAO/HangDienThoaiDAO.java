/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlbandienthoai.DAO;

import com.qlbandienthoai.entity.HangDienThoai;
import com.qlbandienthoai.utils.XJdbc;
import com.sun.jdi.connect.spi.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HangDienThoaiDAO extends EduSysDAO<HangDienThoai, String>{

    @Override
    public void insert(HangDienThoai model) {
        String sql="INSERT INTO HangDienThoai (MaHangDienThoai, TenHangDienThoai) VALUES (?, ?)";
        XJdbc.update(sql, 
                model.getMaHangDienThoai(), 
                model.getTenHangDienThoai());           
    }

    @Override
    public void update(HangDienThoai model) {
         String sql="UPDATE HangDienThoai SET TenHangDienThoai=? WHERE MaHangDienThoai=?";
        XJdbc.update(sql, 
                model.getTenHangDienThoai(),
                model.getMaHangDienThoai());
    }

    @Override
    public void delete(String MaHangDienThoai) {
        String sql="DELETE FROM HangDienThoai WHERE MaHangDienThoai=?";
        XJdbc.update(sql, MaHangDienThoai);
    }

    @Override
    public HangDienThoai selectById(String MaHangDienThoai) {
        String sql="SELECT * FROM HangDienThoai WHERE MaHangDienThoai=?";
        List<HangDienThoai> list = this.selectBySql(sql, MaHangDienThoai);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<HangDienThoai> selectAll() {
        String sql="SELECT * FROM HangDienThoai";
        return this.selectBySql(sql);
    }

    @Override
    protected List<HangDienThoai> selectBySql(String sql, Object... args) {
        List<HangDienThoai> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    HangDienThoai entity=new HangDienThoai();
                    entity.setMaHangDienThoai(rs.getString("MaHangDienThoai"));
                    entity.setTenHangDienThoai(rs.getString("TenHangDienThoai"));
                   
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
    public List<HangDienThoai> selectByName(String keyword) {
    String sql = "SELECT * FROM HangDienThoai WHERE TenHangDienThoai LIKE ?";
    return selectBySql(sql, "%" + keyword + "%");
}
}
