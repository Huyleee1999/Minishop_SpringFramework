package com.lehoanghuy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lehoanghuy.dao.DanhMucDAO;
import com.lehoanghuy.daoimp.DanhMucImp;
import com.lehoanghuy.entity.DanhMucSanPham;

@Service
public class DanhMucService implements DanhMucImp{
	
	@Autowired
	DanhMucDAO danhMucDAO;
	
	public List<DanhMucSanPham> LayDanhMuc() {
		return danhMucDAO.LayDanhMuc();
	}

}
