package com.lehoanghuy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lehoanghuy.dao.ChiTietHoaDonDAO;
import com.lehoanghuy.daoimp.ChiTietHoaDonImp;
import com.lehoanghuy.entity.ChiTietHoaDon;

@Service
public class ChiTietHoaDonService implements ChiTietHoaDonImp{
	
	@Autowired
	ChiTietHoaDonDAO chiTietHoaDonDAO;
	
	@Override
	public Boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		return chiTietHoaDonDAO.ThemChiTietHoaDon(chiTietHoaDon);
	}
	
}
