package com.lehoanghuy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lehoanghuy.dao.MauSanPhamDAO;
import com.lehoanghuy.daoimp.MauSanPhamImp;
import com.lehoanghuy.entity.MauSanPham;

@Service
public class MauSanPhamService implements MauSanPhamImp{

	@Autowired
	MauSanPhamDAO mauSanPhamDAO;
	
	@Override
	public List<MauSanPham> LayDanhSachMau() {
		
		return mauSanPhamDAO.LayDanhSachMau();
	}

}
