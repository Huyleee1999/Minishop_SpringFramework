package com.lehoanghuy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lehoanghuy.entity.DanhMucSanPham;
import com.lehoanghuy.entity.GioHang;
import com.lehoanghuy.entity.SanPham;
import com.lehoanghuy.service.DanhMucService;
import com.lehoanghuy.service.SanPhamService;

import jakarta.servlet.http.HttpSession;




@Controller
@RequestMapping("/chitiet")
@SessionAttributes("giohang")
public class ChiTietController {
	
	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucService danhMucService;
	
	jakarta.servlet.http.HttpSession httpSession;
	
	@GetMapping("/{masanpham}")
	public String Default(@PathVariable int masanpham, ModelMap modelMap, HttpSession httpSession) {
		SanPham sanpham = sanPhamService.LayDanhSachChiTietSanPhamTheoMa(masanpham);
		List<DanhMucSanPham> danhMucSanPham = danhMucService.LayDanhMuc(); 
		
		if(null != httpSession.getAttribute("giohang")) {
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");			
			modelMap.addAttribute("soluongsanphamgiohang", gioHangs.size());
		}
		
		modelMap.addAttribute("sanpham", sanpham);
		modelMap.addAttribute("danhmuc", danhMucSanPham);
		
		
		
		return "chitiet";
	}
	
	
}
