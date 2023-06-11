package com.lehoanghuy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lehoanghuy.dao.HoaDonDAO;
import com.lehoanghuy.daoimp.HoaDonImp;
import com.lehoanghuy.entity.HoaDon;

@Service
public class HoaDonService implements HoaDonImp{
	
	@Autowired
	HoaDonDAO hoaDonDAO;

	@Override
	public int ThemHoaDon(HoaDon hoaDon) {
		return hoaDonDAO.ThemHoaDon(hoaDon);
	}
	
	
}
