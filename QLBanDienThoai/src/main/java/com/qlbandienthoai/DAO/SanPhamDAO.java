package com.qlbandienthoai.DAO;

import com.qlbandienthoai.entity.SanPham;
import com.qlbandienthoai.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class SanPhamDAO {

      public void insert(SanPham model) {
     String insert = String.format( "INSERT INTO SanPham(MaSanPham, TenSanPham, MaHangDienThoai, MoTa, SoLuong, Gia, Hinh) VALUES(?, ?, ?, ?, ?, ?, ?)");
                   XJdbc.update(insert,
                    model.getCode(),
                    model.getName(),
                    model.getNameType(),
                    model.getNote(),
                    model.getQuatity(),
                    model.getPrice(),
                   model.getImage()
                   );
    }
      
    public void update(SanPham model) {
        String sql="UPDATE SanPham SET TenSanPham=?, MaHangDienThoai=?, MoTa=?, SoLuong=?, Gia=?, Hinh=? WHERE MaSanPham=?";
        XJdbc.update(sql, 
                model.getName(),
                    model.getNameType(),
                    model.getNote(),
                    model.getQuatity(),
                    model.getPrice(),
                   model.getImage(),
                model.getCode());
    }  
      
     public void delete(String MaCode) {
        String sql="DELETE FROM SanPham WHERE MaSanPham=?";
        XJdbc.update(sql, MaCode);
    }  
      
      
      
      
       public List<SanPham> selectByName(String keyword) {
        String sql = "SELECT * FROM SanPham WHERE TenSanPham LIKE ?";
        return selectBySql(sql, "%" + keyword + "%");
    }
      
      
      
      
      

    // Method to retrieve all products with brand names
    public List<SanPham> selectAll() {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT sp.MaSanPham, sp.TenSanPham, hdt.TenHangDienThoai, sp.MoTa, sp.SoLuong, sp.Gia, sp.Hinh "
                + "FROM SANPHAM sp "
                + "JOIN HANGDIENTHOAI hdt ON sp.MaHangDienThoai = hdt.MaHangDienThoai";
        try {
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setCode(rs.getString("MaSanPham"));
                sanPham.setName(rs.getString("TenSanPham"));
                sanPham.setNameType(rs.getString("TenHangDienThoai"));
                sanPham.setNote(rs.getString("MoTa")); // Set brand name
// Set brand name
                sanPham.setQuatity(rs.getInt("SoLuong"));
                sanPham.setPrice(rs.getInt("Gia"));
                                sanPham.setImage(rs.getString("Hinh"));

                list.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    protected List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    SanPham entity=new SanPham();
                    entity.setCode(rs.getString("MaSanPham"));
                    entity.setName(rs.getString("TenSanPham"));
                    entity.setNameType(rs.getString("MaHangDienThoai"));
                    entity.setNote(rs.getString("MoTa"));
                    entity.setQuatity(rs.getInt("SoLuong"));
                    entity.setPrice(rs.getInt("Gia"));
                    entity.setImage(rs.getString("Hinh"));
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

    public SanPham selectById(String MaSanPham) {
        String sql="SELECT * FROM SANPHAM WHERE MaSanPham=?";
        List<SanPham> list = this.selectBySql(sql, MaSanPham);
        return list.size() > 0 ? list.get(0) : null;
    }
}
