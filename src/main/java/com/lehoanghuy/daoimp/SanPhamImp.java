package com.lehoanghuy.daoimp;

import java.util.List;

import com.lehoanghuy.entity.SanPham;

public interface SanPhamImp {
	List<SanPham> layDanhSachSanPhamLimit(int spbatdau);
	public SanPham LayDanhSachChiTietSanPhamTheoMa(int masanpham);
	public List<SanPham> laySanPhamTheoMaDanhMuc(int madanhmuc);
	public Boolean XoaSanPhamTheoMaSanPham(int masanpham);
	public Boolean ThemSanPham(SanPham sanPham);
	public Boolean CapNhatSanPham(SanPham sanPham);
}
