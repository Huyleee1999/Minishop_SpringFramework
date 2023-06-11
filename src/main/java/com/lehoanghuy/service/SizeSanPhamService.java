package com.lehoanghuy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lehoanghuy.dao.SizeSanPhamDAO;
import com.lehoanghuy.daoimp.SizeSanPhamImp;
import com.lehoanghuy.entity.SizeSanPham;

@Service
public class SizeSanPhamService implements SizeSanPhamImp{
	
	@Autowired
	SizeSanPhamDAO sizeSanPhamDAO;
	
	@Override
	public List<SizeSanPham> LayDanhSachSize() {
		
		return sizeSanPhamDAO.LayDanhSachSize();
	}

}
