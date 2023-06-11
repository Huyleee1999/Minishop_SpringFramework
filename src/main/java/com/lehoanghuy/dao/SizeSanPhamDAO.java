package com.lehoanghuy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.lehoanghuy.daoimp.SizeSanPhamImp;
import com.lehoanghuy.entity.SizeSanPham;

import util.HibernateUtil;

@Repository
//@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SizeSanPhamDAO implements SizeSanPhamImp{
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public List<SizeSanPham> LayDanhSachSize() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		
		String hql = "from SIZESANPHAM";
		List<SizeSanPham> listSizeSanPhams = session.createQuery(hql).getResultList();
		
		tr.commit();
		session.close();
		return listSizeSanPhams;
	}
}
