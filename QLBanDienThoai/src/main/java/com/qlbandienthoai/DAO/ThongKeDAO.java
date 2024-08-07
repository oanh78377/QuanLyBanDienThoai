/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlbandienthoai.DAO;

import com.qlbandienthoai.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ThongKeDAO {
     private List<Object[]> getListOfArray(String sql, String[] cols, Object...args){
        try {
            List<Object[]> list=new ArrayList<>();
            ResultSet rs = XJdbc.query(sql, args);
            while(rs.next()){
                Object[] vals = new Object[cols.length];
                for(int i=0; i<cols.length; i++){
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
     
     
     public List<Object[]> getDoanhThu(int nam){
        String sql = "{CALL sp_ThongKeDoanhThu (?)}"; //
        String[] cols = {"SanPham", "SoLuongSanPham", "SoLuongBan", "SLTonKho", "DoanhThu", "HDThapNhat", "HDCaoNhat", "HDTrungBinh"};
        return this.getListOfArray(sql, cols, nam);
    }
     
     
     
}
