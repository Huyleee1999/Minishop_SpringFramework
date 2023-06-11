package com.lehoanghuy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.lehoanghuy.daoimp.DanhMucImp;
import com.lehoanghuy.entity.DanhMucSanPham;

import util.HibernateUtil;

@Repository
//@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucDAO implements DanhMucImp{
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public List<DanhMucSanPham> LayDanhMuc() {
		
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String hql = "FROM DANHMUCSANPHAM";
		List<DanhMucSanPham> danhMucSanPham = session.createQuery(hql).getResultList();
		
		return danhMucSanPham;
	}

}
