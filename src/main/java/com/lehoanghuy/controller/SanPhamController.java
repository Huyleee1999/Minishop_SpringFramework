package com.lehoanghuy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lehoanghuy.entity.DanhMucSanPham;
import com.lehoanghuy.entity.SanPham;
import com.lehoanghuy.service.DanhMucService;
import com.lehoanghuy.service.SanPhamService;

@Controller
@RequestMapping("sanpham/")
public class SanPhamController {
	
	@Autowired
	DanhMucService danhMucService;
	
	@Autowired
	SanPhamService sanPhamService;
	
	@GetMapping("{id}/{tendanhmuc}")
	public String Default(ModelMap modelMap, @PathVariable int id, @PathVariable String tendanhmuc) {
		
		List<SanPham> listsanpham = sanPhamService.laySanPhamTheoMaDanhMuc(id);
		List<DanhMucSanPham> danhMucSanPham = danhMucService.LayDanhMuc(); 
		
		modelMap.addAttribute("danhmuc", danhMucSanPham);
		modelMap.addAttribute("tendanhmuc", tendanhmuc);
		modelMap.addAttribute("listSanPham", listsanpham);
		
		return "sanpham";
	}
}
