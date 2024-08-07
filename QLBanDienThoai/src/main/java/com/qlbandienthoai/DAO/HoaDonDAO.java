/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlbandienthoai.DAO;

import com.qlbandienthoai.entity.HoaDon;
import com.qlbandienthoai.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HoaDonDAO extends EduSysDAO<HoaDon, String>{

    
    public void insert(HoaDon model) {
        String sql="INSERT INTO HOADON (MaHoaDon,  MaKhachHang ,MaNhanVien ,TrangThai, GiaBan,  NgayMua) VALUES (?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql, 
                model.getMaHoaDon(), 
                model.getMaKhachHang(), 
                model.getMaNhanVien(), 
                model.getTrangThai(), 
                model.getGiaBan(),
                model.getNgayMua());
    }

    
    public void update(HoaDon model) {
        String sql="UPDATE HOADON SET MaKhachHang=?, MaNhanVien=?, TrangThai=?, GiaBan=?, NgayMua=? WHERE MaHoaDon=?";
        XJdbc.update(sql, 
                model.getMaKhachHang(),
                model.getMaNhanVien(),
                model.getTrangThai(),
                model.getGiaBan(),
                model.getNgayMua(),
                model.getMaHoaDon());
    
    }

    
    public void delete(String MaNhanVien) {
        String sql="DELETE FROM HOADON WHERE MaHoaDon=?";
        XJdbc.update(sql, MaNhanVien);
    }

    
    public HoaDon selectById(String MaNhanVien) {
        String sql="SELECT * FROM HOADON WHERE MaHoaDon=?";
        Object[] MaHoaDon = null;
        List<HoaDon> list = this.selectBySql(sql, MaHoaDon);
        return list.size() > 0 ? list.get(0) : null;
    }

    
    public List<HoaDon> selectAll() {
        String sql="SELECT * FROM HOADON";
        return this.selectBySql(sql);
    }

   
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    HoaDon entity=new HoaDon();
                    entity.setMaHoaDon(rs.getString("MaHoaDon"));
                    entity.setMaKhachHang(rs.getString("MaKhachHang"));
                    entity.setMaNhanVien(rs.getString("MaNhanVien"));
                    entity.setTrangThai(rs.getString("TrangThai"));
                    entity.setGiaBan(rs.getInt("GiaBan"));
                    entity.setNgayMua(rs.getDate("NgayMua"));
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
{
    
    
}

    public List<HoaDon> selectByKeyword(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public List<Integer> selectYears() {
        String sql="SELECT DISTINCT year(NgayMua) Year FROM HoaDon ORDER BY Year DESC";
        List<Integer> list=new ArrayList<>();
        try {
           ResultSet rs = XJdbc.query(sql);
           while(rs.next()){
                 list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
