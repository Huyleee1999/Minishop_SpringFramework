package com.lehoanghuy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.lehoanghuy.daoimp.ChiTietHoaDonImp;
import com.lehoanghuy.entity.ChiTietHoaDon;
import com.lehoanghuy.entity.ChiTietHoaDonId;

import util.HibernateUtil;

@Repository
//@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChiTietHoaDonDAO implements ChiTietHoaDonImp{
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public Boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		
		ChiTietHoaDonId id = (ChiTietHoaDonId)session.save(chiTietHoaDon);
		tr.commit();
		session.close();
		
		if(null != id) {
			return true;
		} else {
			return false;
		}
	}

}
