package com.lehoanghuy.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lehoanghuy.entity.ChiTietSanPham;
import com.lehoanghuy.entity.DanhMucSanPham;
import com.lehoanghuy.entity.GioHang;
import com.lehoanghuy.entity.JSON_SanPham;
import com.lehoanghuy.entity.MauSanPham;
import com.lehoanghuy.entity.SanPham;
import com.lehoanghuy.entity.SizeSanPham;
import com.lehoanghuy.service.NhanVienService;
import com.lehoanghuy.service.SanPhamService;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("api/")
@SessionAttributes({"user", "giohang"})
public class ApiController{
	
	@Autowired
	NhanVienService nhanVienService;
	
	@Autowired
	SanPhamService sanPhamService;
	
	jakarta.servlet.http.HttpSession httpSession;
	

	@GetMapping("KiemTraDangNhap")
	@ResponseBody
	public String KiemTraDangNhap(@RequestParam String email, @RequestParam String matkhau, ModelMap modelMap, jakarta.servlet.http.HttpSession httpSession) {
					
		Boolean kiemtra = nhanVienService.KiemTraDangNhap(email, matkhau);
		modelMap.addAttribute("user", email);
		
		return "" + kiemtra;
	}
	
	
	@GetMapping("CapNhatGioHang")
	@ResponseBody
	public void CapNhatGioHang(jakarta.servlet.http.HttpSession httpSession,@RequestParam int soluong,@RequestParam int masp,@RequestParam int mamau,@RequestParam int masize) {
		if(null != httpSession.getAttribute("giohang")) {
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri = KiemTraSanPhamDaTonTaiGioHang(listGioHangs, masp, masize, mamau, httpSession);
			listGioHangs.get(vitri).setSoluong(soluong);
		}
	}
	
	@GetMapping("XoaGioHang")
	@ResponseBody
	public void XoaGioHang(jakarta.servlet.http.HttpSession httpSession, int masp, int mamau, int masize) {
		if(null != httpSession.getAttribute("giohang")) {
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri = KiemTraSanPhamDaTonTaiGioHang(listGioHangs, masp, masize, mamau, httpSession);
			listGioHangs.remove(vitri);
		}
	}
	
	
	@GetMapping("ThemGioHang")
	@ResponseBody
	public String ThemGioHang(@RequestParam int masp, @RequestParam int masize, @RequestParam int mamau, @RequestParam String tensp, @RequestParam String giatien, @RequestParam String tenmau, @RequestParam String tensize, @RequestParam int soluong, @RequestParam int machitiet, jakarta.servlet.http.HttpSession httpSession) {		
		
		if(null == httpSession.getAttribute("giohang")) {
			List<GioHang> gioHangs = new ArrayList<>();	
			GioHang gioHang = new GioHang();
		    gioHang.setMasp(masp);
		    gioHang.setMasize(masize);
		    gioHang.setMamau(mamau);
		    gioHang.setTensp(tensp);
		    gioHang.setGiatien(giatien);
		    gioHang.setTenmau(tenmau);
		    gioHang.setTensize(tensize);
		    gioHang.setSoluong(1);
		    gioHang.setMachitiet(machitiet);
		    
		    gioHangs.add(gioHang);
		    httpSession.setAttribute("giohang", gioHangs);
		    
		    return gioHangs.size() + "";
		
		} else {
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri = KiemTraSanPhamDaTonTaiGioHang(listGioHangs, masp, masize, mamau, httpSession);
			if(vitri == -1) {				
				GioHang gioHang = new GioHang();
			    gioHang.setMasp(masp);
			    gioHang.setMasize(masize);
			    gioHang.setMamau(mamau);
			    gioHang.setTensp(tensp);
			    gioHang.setGiatien(giatien);
			    gioHang.setTenmau(tenmau);
			    gioHang.setTensize(tensize);
			    gioHang.setSoluong(1);
			    gioHang.setMachitiet(machitiet);
			    
			    listGioHangs.add(gioHang);
			} else {
				int soluongmoi = listGioHangs.get(vitri).getSoluong() +1;
				listGioHangs.get(vitri).setSoluong(soluongmoi);
			}
			
			return listGioHangs.size() + "";
		}
	}
	
	private int KiemTraSanPhamDaTonTaiGioHang(List<GioHang> listGioHangs, int masp, int masize, int mamau, jakarta.servlet.http.HttpSession httpSession2) {
		for (int i = 0; i < listGioHangs.size(); i++) {
			if(listGioHangs.get(i).getMasp() == masp && listGioHangs.get(i).getMasize() == masize && listGioHangs.get(i).getMamau() == mamau) {
				return i;
			}
		}
		return -1;
	}
	
//	@GetMapping("LaySoLuongGioHang")
//	@ResponseBody
//	public String LaySoLuongGioHang(jakarta.servlet.http.HttpSession httpSession) {
//		if(null != httpSession.getAttribute("giohang")) {
//			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
//			return listGioHangs.size() + "";
//		}
//		return "";
//	}
	
	@GetMapping(path="LaySanPhamLimit", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String LaySanPhamLimit(@RequestParam int spbatdau) {
		
		String html = "";
		
		List<SanPham> lisSanPhams = sanPhamService.layDanhSachSanPhamLimit(spbatdau);
		for (SanPham sanPham : lisSanPhams) {
			html += "<tr>";
			html += "<td>\r\n"
					+ "						<div class=\"form-check\">\r\n"
					+ "					  		<label class=\"form-check-label\">\r\n"
					+ "					    		<input type=\"checkbox\" class=\"form-check-input checkboxsanpham\" value=\""+ sanPham.getMasanpham() +"\">\r\n"
					+ "					  		</label>\r\n"
					+ "						</div>\r\n"
					+ "					</td>";
			
			html += "<td class=\"tensp\" data-masp=" + sanPham.getMasanpham() + ">" + sanPham.getTensanpham() + "</td>";
			html += "<td class=\"giatien\">" + sanPham.getGiatien() + "</td>";
			html += "<td class=\"gianhcho\">" + sanPham.getGianhcho() + "</td>";	
			html += "<td style=\"color: black\" class=\"capnhatsanpham btn btn-outline-info\" data-id=" + sanPham.getMasanpham() + ">Sửa</td>";
			html += "</tr>";
		}
		
		return html;
	}
	
	@GetMapping("XoaSanPham")
	@ResponseBody
	public String XoaSanPhamTheoMaSanPham(@RequestParam int masp) {
		sanPhamService.XoaSanPhamTheoMaSanPham(masp);		
		
		return "true";		
	}
	
	@Autowired
	ServletContext context;
	
	@PostMapping("UploadFile")
	@ResponseBody
	public String UploadFile(MultipartHttpServletRequest request) {
		
		String path_save_file = context.getRealPath("/resources/Image/HinhSanPhamRoutine");
		Iterator<String> listNames = request.getFileNames();
		MultipartFile mpf = request.getFile(listNames.next()); 
		
		File file_save = new File(path_save_file + mpf.getOriginalFilename());
		try {
			mpf.transferTo(file_save);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(path_save_file);
		return "true";		
	}
	
	@PostMapping("themsanpham")
	@ResponseBody
	public void themsanpham(@RequestParam String datajson) {
		ObjectMapper objectMapper = new ObjectMapper();

		JsonNode jsonObject;
		try {
			SanPham sanPham = new SanPham();
			jsonObject = objectMapper.readTree(datajson);
			
			DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
			danhMucSanPham.setMadanhmuc(jsonObject.get("danhmucsanpham").asInt());
			
			JsonNode jsonChitiet = jsonObject.get("chitietsanpham");
			Set<ChiTietSanPham> listChiTiet = new HashSet<>();
			for (JsonNode objectChitiet : jsonChitiet) {
				ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
				
				MauSanPham mauSanPham = new MauSanPham();
				mauSanPham.setMamau(objectChitiet.get("mausanpham").asInt());				
			
				SizeSanPham sizeSanPham = new SizeSanPham();
				sizeSanPham.setMasize(objectChitiet.get("sizesanpham").asInt());				
				
				chiTietSanPham.setMausanpham(mauSanPham);
				chiTietSanPham.setSizesanpham(sizeSanPham);
				chiTietSanPham.setSoluong(objectChitiet.get("soluong").asInt());
			
				listChiTiet.add(chiTietSanPham);
			}
			
			String tensanpham = jsonObject.get("tensanpham").asText();
			String giatien = jsonObject.get("giatien").asText();
			String mota = jsonObject.get("mota").asText();
			String hinhsanpham = jsonObject.get("hinhsanpham").asText();
			String gianhcho = jsonObject.get("gianhcho").asText();
			
			sanPham.setChitietsanpham(listChiTiet);
			sanPham.setDanhmucsanpham(danhMucSanPham);
			sanPham.setTensanpham(tensanpham);
			sanPham.setGiatien(giatien);
			sanPham.setGianhcho(gianhcho);
			sanPham.setMota(mota);
			sanPham.setHinhsanpham(hinhsanpham);
			
			System.out.println(jsonObject.get("giatien").asText() + jsonObject.get("mota").asText());
			
			sanPhamService.ThemSanPham(sanPham);
			
		} catch (JsonMappingException e) {			
			e.printStackTrace();
		} catch (JsonProcessingException e) {			
			e.printStackTrace();
		}
	}
	
	@PostMapping("capnhatsanpham")
	@ResponseBody
	public void capnhatsanpham(@RequestParam String datajson) {
		ObjectMapper objectMapper = new ObjectMapper();

		JsonNode jsonObject;
		try {
			SanPham sanPham = new SanPham();
			jsonObject = objectMapper.readTree(datajson);
			
			DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
			danhMucSanPham.setMadanhmuc(jsonObject.get("danhmucsanpham").asInt());
			
			JsonNode jsonChitiet = jsonObject.get("chitietsanpham");
			Set<ChiTietSanPham> listChiTiet = new HashSet<>();
			for (JsonNode objectChitiet : jsonChitiet) {
				ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
				
				MauSanPham mauSanPham = new MauSanPham();
				mauSanPham.setMamau(objectChitiet.get("mausanpham").asInt());				
			
				SizeSanPham sizeSanPham = new SizeSanPham();
				sizeSanPham.setMasize(objectChitiet.get("sizesanpham").asInt());				
				
				chiTietSanPham.setMausanpham(mauSanPham);
				chiTietSanPham.setSizesanpham(sizeSanPham);
				chiTietSanPham.setSoluong(objectChitiet.get("soluong").asInt());
			
				listChiTiet.add(chiTietSanPham);
			}
			
			String tensanpham = jsonObject.get("tensanpham").asText();
			String giatien = jsonObject.get("giatien").asText();
			String mota = jsonObject.get("mota").asText();
			String hinhsanpham = jsonObject.get("hinhsanpham").asText();
			String gianhcho = jsonObject.get("gianhcho").asText();
			int masanpham = jsonObject.get("masanpham").asInt();
			
			sanPham.setChitietsanpham(listChiTiet);
			sanPham.setDanhmucsanpham(danhMucSanPham);
			sanPham.setTensanpham(tensanpham);
			sanPham.setGiatien(giatien);
			sanPham.setGianhcho(gianhcho);
			sanPham.setMota(mota);
			sanPham.setHinhsanpham(hinhsanpham);
			sanPham.setMasanpham(masanpham);
			
			System.out.println(jsonObject.get("giatien").asText() + jsonObject.get("mota").asText());
			
			sanPhamService.CapNhatSanPham(sanPham);
			
		} catch (JsonMappingException e) {			
			e.printStackTrace();
		} catch (JsonProcessingException e) {			
			e.printStackTrace();
		}
	}
	
	@PostMapping(path="LayDanhSachSanPhamTheoMa", produces = "application/json; charset=utf-8")
	@ResponseBody
	public JSON_SanPham LayDanhSachSanPhamTheoMa(@RequestParam int masanpham) {
		
		JSON_SanPham json_SanPham = new JSON_SanPham();
		SanPham sanPhams = sanPhamService.LayDanhSachChiTietSanPhamTheoMa(masanpham);
		
		json_SanPham.setMasanpham(sanPhams.getMasanpham());
		json_SanPham.setTensanpham(sanPhams.getTensanpham());
		json_SanPham.setGiatien(sanPhams.getGiatien());
		json_SanPham.setMota(sanPhams.getMota());
		json_SanPham.setHinhsanpham(sanPhams.getHinhsanpham());
		json_SanPham.setGianhcho(sanPhams.getGianhcho());
		
		DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
		danhMucSanPham.setMadanhmuc(sanPhams.getDanhmucsanpham().getMadanhmuc());
		danhMucSanPham.setTendanhmuc(sanPhams.getDanhmucsanpham().getTendanhmuc());
		
		Set<ChiTietSanPham> chiTietSanPhams = new HashSet<>();
		for (ChiTietSanPham value : sanPhams.getChitietsanpham()) {
			
			ChiTietSanPham chiTietSanPham = new ChiTietSanPham();			
			chiTietSanPham.setMachitietsanpham(value.getMachitietsanpham());
			
			MauSanPham mauSanPham = new MauSanPham();
			mauSanPham.setMamau(value.getMausanpham().getMamau());
			mauSanPham.setTenmau(value.getMausanpham().getTenmau());
			chiTietSanPham.setMausanpham(mauSanPham);
			
			SizeSanPham sizeSanPham = new SizeSanPham();
			sizeSanPham.setMasize(value.getSizesanpham().getMasize());
			sizeSanPham.setSize(value.getSizesanpham().getSize());
			chiTietSanPham.setSizesanpham(sizeSanPham);
			
			chiTietSanPham.setSoluong(value.getSoluong());
			
			chiTietSanPhams.add(chiTietSanPham);
		}
		
		json_SanPham.setDanhmucsanpham(danhMucSanPham);
		json_SanPham.setChitietsanpham(chiTietSanPhams);

		return json_SanPham;		
	}
}
