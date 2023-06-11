package com.lehoanghuy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.lehoanghuy.daoimp.HoaDonImp;
import com.lehoanghuy.entity.HoaDon;

import util.HibernateUtil;

@Repository
//@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HoaDonDAO implements HoaDonImp{
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); 
	
	@Override
	public int ThemHoaDon(HoaDon hoaDon) {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			
			int id = (int) session.save(hoaDon);
			tr.commit();
			session.close();
			if(0 < id) {
				return id;
			} else {
				return 0;
			}	
	}
}
