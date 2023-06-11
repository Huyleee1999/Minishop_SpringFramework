package com.lehoanghuy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lehoanghuy.dao.NhanVienDAO;
import com.lehoanghuy.daoimp.NhanVienImp;
import com.lehoanghuy.entity.NhanVien;

@Service
public class NhanVienService implements NhanVienImp{
	
	@Autowired
	NhanVienDAO nvDao;

	public Boolean KiemTraDangNhap(String email, String matkhau) {
		boolean kiemtra = nvDao.KiemTraDangNhap(email, matkhau);
		return kiemtra;
	}

	public Boolean ThemNhanVien(NhanVien nv) {
		boolean ktThem = nvDao.ThemNhanVien(nv); 
		return ktThem;
	}

	
	
	
}
