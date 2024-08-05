/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlbandienthoai.DAO;
import com.qlbandienthoai.entity.HoaDonChiTiet;
import com.qlbandienthoai.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ADMIN
 */
public class HoaDonChiTietDAO extends EduSysDAO<HoaDonChiTiet, String>{
     public void insert(HoaDonChiTiet model) {
        String sql="INSERT INTO HOADONCHITIET (MaHoaDonChiTiet,MaSanPham, MaHoaDon, SoLuong, GiaBan) VALUES (?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql, 
                model.getMaHoaDonChiTiet(), 
                model.getMaSanPham(), 
                model.getMaHoaDon(), 
                model.getSoLuong(), 
                model.getGiaban());
         
                }

    
    public void update(HoaDonChiTiet model) {
        String sql="UPDATE HOADONCHITIET SET MaSanPham=?, MaHoaDon=?, SoLuong=?, GiaBan=? WHERE MaHoaDonChiTiet=?";
        XJdbc.update(sql, 
                model.getMaSanPham(),
                model.getMaHoaDon(),
                model.getSoLuong(),
                model.getGiaban(),
                model.getMaHoaDonChiTiet());
    
    }

    
    public void delete(String MaHoaDonChiTiet) {
        String sql="DELETE FROM HOADONCHITIET WHERE MaHoaDonChiTiet=?";
        XJdbc.update(sql, MaHoaDonChiTiet);
    }

    
    public HoaDonChiTiet selectById(String MaHoaDonChiTiet) {
        String sql="SELECT * FROM HOADONCHITIET WHERE MaHoaDonChiTiet=?";
        List<HoaDonChiTiet> list = this.selectBySql(sql, MaHoaDonChiTiet);
        return list.size() > 0 ? list.get(0) : null;
    }

    
    public List<HoaDonChiTiet> selectAll() {
        String sql="SELECT * FROM HOADONCHITIET";
        return this.selectBySql(sql);
    }

   
    protected List<HoaDonChiTiet> selectBySql(String sql, Object... args) {
        List<HoaDonChiTiet> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    HoaDonChiTiet entity=new HoaDonChiTiet();
                    entity.setMaHoaDonChiTiet(rs.getString("MaHoaDonChiTiet"));
                    entity.setMaSanPham(rs.getString("SanPham"));
                    entity.setMaHoaDon(rs.getString("MaHoaDon"));
                    entity.setSoLuong(rs.getInt("SoLuong"));
                    entity.setGiaban(rs.getInt("GiaBan"));
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
