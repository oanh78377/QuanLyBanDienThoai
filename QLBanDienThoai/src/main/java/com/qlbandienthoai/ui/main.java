package com.qlbandienthoai.ui;

import javax.swing.JFrame;

public class main {

    public static void main(String[] args) {
        // Tạo một JFrame để làm parent cho DangNhapJDialog
        JFrame parentFrame = new JFrame();
        parentFrame.setUndecorated(true); // Không hiển thị frame
        parentFrame.setSize(1, 1); // Kích thước nhỏ
        parentFrame.setLocationRelativeTo(null); // Đặt vị trí frame

        // Khởi tạo DangNhapJDialog với parentFrame và true cho modal
        ChaoJDialog chao = new  ChaoJDialog(parentFrame, true);
                chao.setVisible(true);
        DangNhapJDialog login = new DangNhapJDialog(parentFrame, true);
        login.setVisible(true);

        // Giải phóng tài nguyên của parentFrame sau khi dialog đóng
        parentFrame.dispose();
    }
}
