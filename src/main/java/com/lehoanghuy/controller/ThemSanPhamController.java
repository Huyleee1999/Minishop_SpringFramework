package com.lehoanghuy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lehoanghuy.entity.DanhMucSanPham;
import com.lehoanghuy.entity.MauSanPham;
import com.lehoanghuy.entity.SanPham;
import com.lehoanghuy.entity.SizeSanPham;
import com.lehoanghuy.service.DanhMucService;
import com.lehoanghuy.service.MauSanPhamService;
import com.lehoanghuy.service.SanPhamService;
import com.lehoanghuy.service.SizeSanPhamService;

@Controller
@RequestMapping("themsanpham/")
public class ThemSanPhamController {
	
	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucService danhMucService;
	
	@Autowired
	MauSanPhamService mauSanPhamService;
	
	@Autowired
	SizeSanPhamService sizeSanPhamService;
	
	@GetMapping
	public String Default(ModelMap modelMap) {
		List<SanPham> listSanPhams =  sanPhamService.layDanhSachSanPhamLimit(0);
		List<SanPham> allSanPham = sanPhamService.layDanhSachSanPhamLimit(-1);
		List<DanhMucSanPham> danhMucSanPham = danhMucService.LayDanhMuc(); 
		List<MauSanPham> listMauSanPhams = mauSanPhamService.LayDanhSachMau();
		List<SizeSanPham> listsizeSanPhams = sizeSanPhamService.LayDanhSachSize();
		
		double tongsopage = Math.ceil((double)allSanPham.size() / 5);		
		modelMap.addAttribute("listSanPham", listSanPhams);
		modelMap.addAttribute("allSanPham", allSanPham);
		modelMap.addAttribute("tongsopage", tongsopage);
		modelMap.addAttribute("danhmuc", danhMucSanPham);
		modelMap.addAttribute("listsize", listsizeSanPhams);
		modelMap.addAttribute("listmau", listMauSanPhams);
		
		return "themsanpham";
	}
}
