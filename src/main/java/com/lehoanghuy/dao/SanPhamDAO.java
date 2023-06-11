package com.lehoanghuy.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.lehoanghuy.daoimp.SanPhamImp;
import com.lehoanghuy.entity.ChiTietHoaDon;
import com.lehoanghuy.entity.ChiTietHoaDonId;
import com.lehoanghuy.entity.ChiTietSanPham;
import com.lehoanghuy.entity.SanPham;

import util.HibernateUtil;

@Repository
//@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS) 
public class SanPhamDAO implements SanPhamImp{
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public List<SanPham> layDanhSachSanPhamLimit(int spbatdau) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		
		List<SanPham> listSanPhams = new ArrayList<>();
		if(spbatdau < 0) {
			String hql = "FROM SANPHAM";
			listSanPhams = (List<SanPham>) session.createQuery(hql).getResultList();
		} else {
			listSanPhams = (List<SanPham>) session.createQuery("FROM SANPHAM").setFirstResult(spbatdau).setMaxResults(5).getResultList();		
		}
		return listSanPhams;
	}

	public SanPham LayDanhSachChiTietSanPhamTheoMa(int masanpham) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		
		String hql = "FROM SANPHAM sp where sp.masanpham = " + masanpham;
		SanPham sanpham = (SanPham) session.createQuery(hql).getSingleResult();
		
		return sanpham;
	}

	@Override
	public List<SanPham> laySanPhamTheoMaDanhMuc(int madanhmuc) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		
		String hql = "FROM SANPHAM sp where sp.danhmucsanpham.madanhmuc = " + madanhmuc;
		List<SanPham> listSanPhams = (List<SanPham>) session.createQuery(hql).getResultList();
		
		return listSanPhams;
	}

	@Override
	public Boolean XoaSanPhamTheoMaSanPham(int masanpham) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();		
		SanPham sanPham = session.get(SanPham.class, masanpham);
		
		Set<ChiTietSanPham> chiTietSanPhams = sanPham.getChitietsanpham();
		for (ChiTietSanPham chiTietSanPham : chiTietSanPhams) {
			
			session.createQuery("delete CHITIETHOADON WHERE machitietsanpham="+chiTietSanPham.getMachitietsanpham()).executeUpdate();
		}
		
		session.delete(sanPham);
		tr.commit();
		session.close();
		
		return false;
	}

	@Override
	public Boolean ThemSanPham(SanPham sanPham) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		
		session.save(sanPham);
		tr.commit();
		session.close();
		
		return true;		
	}

	@Override
	public Boolean CapNhatSanPham(SanPham sanPham) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		
		session.saveOrUpdate(sanPham);
		
		tr.commit();
		session.close();
		return false;
	}

	
}
