package com.lehoanghuy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.lehoanghuy.daoimp.NhanVienImp;
import com.lehoanghuy.entity.NhanVien;

import util.HibernateUtil;

@Repository
//@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS) 
public class NhanVienDAO implements NhanVienImp{
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public Boolean KiemTraDangNhap(String email, String matkhau) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			NhanVien nv = (NhanVien) session.createQuery("from NHANVIEN where email='"+ email +"' AND matkhau='"+ matkhau +"'").getSingleResult();
			if(nv != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean ThemNhanVien(NhanVien nv) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		
		int manhanvien = (Integer) session.save(nv);
		tr.commit();
		session.close();
		
		if(manhanvien > 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	

	
	
	
}
