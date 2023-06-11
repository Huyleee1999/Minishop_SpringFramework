package com.lehoanghuy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lehoanghuy.dao.SanPhamDAO;
import com.lehoanghuy.daoimp.SanPhamImp;
import com.lehoanghuy.entity.SanPham;

@Service
public class SanPhamService implements SanPhamImp{
	@Autowired
	SanPhamDAO sanPhamDAO;

	public List<SanPham> layDanhSachSanPhamLimit(int spbatdau) {
		
		return sanPhamDAO.layDanhSachSanPhamLimit(spbatdau);
	}

	public SanPham LayDanhSachChiTietSanPhamTheoMa(int masanpham) {
		
		return sanPhamDAO.LayDanhSachChiTietSanPhamTheoMa(masanpham);
	}

	@Override
	public List<SanPham> laySanPhamTheoMaDanhMuc(int madanhmuc) {
		return sanPhamDAO.laySanPhamTheoMaDanhMuc(madanhmuc);
	}

	@Override
	public Boolean XoaSanPhamTheoMaSanPham(int masanpham) {
		return sanPhamDAO.XoaSanPhamTheoMaSanPham(masanpham);
	}

	@Override
	public Boolean ThemSanPham(SanPham sanPham) {
		return sanPhamDAO.ThemSanPham(sanPham);
		
	}

	@Override
	public Boolean CapNhatSanPham(SanPham sanPham) {
		
		return sanPhamDAO.CapNhatSanPham(sanPham);
	}
}
