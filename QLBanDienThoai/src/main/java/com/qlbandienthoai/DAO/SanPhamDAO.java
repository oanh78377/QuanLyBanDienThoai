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

    // Method to retrieve all products with brand names
    public List<SanPham> selectAll() {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT sp.MaSanPham, sp.TenSanPham, hdt.TenHangDienThoai AS TenHangDienThoai, sp.MoTa, sp.SoLuong, sp.Gia, sp.Hinh "
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
}
