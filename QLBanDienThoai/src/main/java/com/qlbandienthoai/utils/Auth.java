package com.qlbandienthoai.utils;

import com.qlbandienthoai.entity.NhanVien;

public class Auth {
    /**
     * Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
     */
    public static NhanVien user = null;
    
    /**
     * Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
     */
    public static void clear() {
        Auth.user = null;
    }

    /**
     * Kiểm tra xem đã đăng nhập hay chưa.
     * @return true nếu đã đăng nhập, false nếu chưa đăng nhập
     */
    public static boolean isLogin() {
        return Auth.user != null;
    }

    /**
     * Kiểm tra xem có phải là trưởng phòng hay không.
     * @return true nếu là trưởng phòng và đã đăng nhập, false nếu không phải trưởng phòng hoặc chưa đăng nhập
     */
//    public static boolean isManager() {
//        return isLogin() && user.getVaiTro();
//    }
}
