package com.lehoanghuy.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lehoanghuy.entity.ChiTietHoaDon;
import com.lehoanghuy.entity.ChiTietHoaDonId;
import com.lehoanghuy.entity.DanhMucSanPham;
import com.lehoanghuy.entity.GioHang;
import com.lehoanghuy.entity.HoaDon;
import com.lehoanghuy.service.ChiTietHoaDonService;
import com.lehoanghuy.service.DanhMucService;
import com.lehoanghuy.service.HoaDonService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("giohang/")
public class GioHangController {
	
	@Autowired
	HoaDonService hoaDonService;
	
	@Autowired
	ChiTietHoaDonService chiTietHoaDonService;
	
	@Autowired
	DanhMucService danhMucService;
	
	@GetMapping
	public String Default(HttpSession httpSession, ModelMap modelMap) {
		
		if(null != httpSession.getAttribute("giohang")) {
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");			
			modelMap.addAttribute("soluongsanphamgiohang", gioHangs.size());
			modelMap.addAttribute("giohangs", gioHangs);		
		}
		
		List<DanhMucSanPham> danhMucSanPham = danhMucService.LayDanhMuc(); 
		modelMap.addAttribute("danhmuc", danhMucSanPham);
		return "giohang";
	}
	
	@PostMapping
	public String ThemHoaDon(HttpSession httpSession, @RequestParam String tenkhachhang, @RequestParam String sodt, @RequestParam String diachigiaohang, @RequestParam String hinhthucgiaohang, @RequestParam String ghichu) {
		
		if(null != httpSession.getAttribute("giohang")) {
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");			
			
			HoaDon hoadon = new HoaDon();
			hoadon.setTenkhachhang(tenkhachhang);
			hoadon.setSodt(sodt);
			hoadon.setDiachigiaohang(diachigiaohang);
			hoadon.setHinhthucgiaohang(hinhthucgiaohang);
			hoadon.setGhichu(ghichu);
			
			int idHoaDon = hoaDonService.ThemHoaDon(hoadon);
			if(idHoaDon > 0) {
				Set<ChiTietHoaDon> listChiTietHoaDons = new HashSet<>();
				for (GioHang gioHang : gioHangs) {
					ChiTietHoaDonId chiTietHoaDonId = new ChiTietHoaDonId();				
					chiTietHoaDonId.setMachitietsanpham(gioHang.getMachitiet());
					chiTietHoaDonId.setMahoadon(hoadon.getMahoadon());
					
					ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
					chiTietHoaDon.setChiTietHoaDonId(chiTietHoaDonId);
					chiTietHoaDon.setGiatien(gioHang.getGiatien());
					chiTietHoaDon.setSoluong(gioHang.getSoluong());
					
					chiTietHoaDonService.ThemChiTietHoaDon(chiTietHoaDon);
				}
			}else{
				System.out.println("Thên thất bại");
			};	
		}		
		return "giohang";
	}
}
