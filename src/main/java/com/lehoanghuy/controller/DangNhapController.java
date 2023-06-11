package com.lehoanghuy.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lehoanghuy.entity.NhanVien;
import com.lehoanghuy.service.NhanVienService;


@Controller
@RequestMapping("dangnhap/")
public class DangNhapController {
	
	@Autowired
	NhanVienService nhanVienService;
	
	@GetMapping
	public String Default() {
		return "dangnhap";
	}
	
	@PostMapping
	public String DangKy(@RequestParam String email, @RequestParam String matkhau, @RequestParam String nhaplaimatkhau, ModelMap modelMap) {
		Boolean ktmail = validate(email);
		if(ktmail) {
			if(matkhau.equals(nhaplaimatkhau)) {
				NhanVien nv = new NhanVien();
				nv.setEmail(email);
				nv.setTendangnhap(email);
				nv.setMatkhau(matkhau);
				
				boolean ktThem = nhanVienService.ThemNhanVien(nv);
				if(ktThem) {
					modelMap.addAttribute("kiemtradangnhap", "Tạo tài khoản thành công !");
				} else {
					modelMap.addAttribute("kiemtradangnhap", "Tạo tài khoản thất bại !");
				}
			} else {
				modelMap.addAttribute("kiemtradangnhap", "Mật khẩu không trùng khớp !");
			}
		} else {
			modelMap.addAttribute("kiemtradangnhap", "Vui lòng nhập đúng định dạng Email !");
		}
		return "dangnhap";
	}
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
		Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	public static boolean validate(String emailStr) {       
	    Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
	        return matcher.find();
	}
}
