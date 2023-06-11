package com.lehoanghuy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.lehoanghuy.daoimp.MauSanPhamImp;
import com.lehoanghuy.entity.MauSanPham;

import util.HibernateUtil;

@Repository
//@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MauSanPhamDAO implements MauSanPhamImp{
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public List<MauSanPham> LayDanhSachMau() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		
		String hql = "from MAUSANPHAM";
		List<MauSanPham> listmauSanPhams = session.createQuery(hql).getResultList();
		
		tr.commit();
		session.close();
		return listmauSanPhams;
	}
}
