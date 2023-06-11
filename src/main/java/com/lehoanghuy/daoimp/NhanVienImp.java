package com.lehoanghuy.daoimp;

import com.lehoanghuy.entity.NhanVien;

public interface NhanVienImp {
	Boolean KiemTraDangNhap(String email, String matkhau);
	Boolean ThemNhanVien(NhanVien nv);
}
