package com.lehoanghuy.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.lehoanghuy.entity.DanhMucSanPham;
import com.lehoanghuy.entity.SanPham;
import com.lehoanghuy.service.DanhMucService;
import com.lehoanghuy.service.SanPhamService;


@Controller
@RequestMapping("/")
public class TrangChuController{
	
	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucService danhMucService;
	
	@GetMapping
	public String Default(@SessionAttribute(name="user", required = false) String user, ModelMap modelMap, jakarta.servlet.http.HttpSession httpSession) {
		
		if(httpSession.getAttribute("user") != null) {
			String email = (String) httpSession.getAttribute("user");
			System.out.println(email);
			String chucaidau = email.substring(0, 1);
			modelMap.addAttribute("chucaidau", chucaidau);
		}
		System.out.println(httpSession.getAttribute("matkhau"));
		
		List<DanhMucSanPham> danhMucSanPham = danhMucService.LayDanhMuc(); 	
		List<SanPham> listSanPham = sanPhamService.layDanhSachSanPhamLimit(0);
		modelMap.addAttribute("listsanpham", listSanPham);
		modelMap.addAttribute("danhmuc", danhMucSanPham);
		return "trangchu";
	}

}
