<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="header-chitiet" class="container-fluid">
		<nav class="navbar navbar-expand-lg navbar-light none_nav">
			<div class="container-fluid">
				<a class="navbar-brand" href="#"><img src="<c:url value="/resources/Image/h&m.png" />" /></a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-center navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">HOME</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								SẢN PHẨM </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<c:forEach var="danhmucvalue" items="${danhmuc}">
								<li  class="danhmucitemsanpham"><a class="danhmucitem" href='<c:url value="/sanpham/${danhmucvalue.getMadanhmuc()}/ ${danhmucvalue.getTendanhmuc()}"/>'>${danhmucvalue.getTendanhmuc()}</a></li>
								<li><hr class="dropdown-divider"></li>
							</c:forEach>									
							</ul></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">SERVICE</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">CONTACT</a></li>
					</ul>
					
					<ul class="nav navbar-nav navbar-right">
						<li class="login-header-text nav-item"><a href="dangnhap/">LOGIN ${chucaidau}</a></li>
						<li class="login-header-text nav-item"><a href="#">REGISTER</a></li>
						
						<li id="giohang"><a href="#"><img src="<c:url value="/resources/Image/cart.png" />" />
							<c:if test="${soluongsanphamgiohang > 0}">
								<div class="circle-giohang"><span>${soluongsanphamgiohang}</span></div>
							</c:if>
							
							<c:if test="${soluongsanphamgiohang <= 0 || soluongsanphamgiohang == null}">
								<div><span>${soluongsanphamgiohang}</span></div>
							</c:if>
						</a></li>
										
					</ul>
				</div>
			</div>
		</nav>
	</div>
	
	<div class="container">
		<div class="row" style="margin-top: 20px">
		
			<div class="col-md-2 col-sm-2">
				<h3 style="margin-bottom: 20px">DANH MỤC</h3>
				<ul class="mymenu">
					<c:forEach var="danhmucvalue" items="${danhmuc}">
						<li><a href="#">${danhmucvalue.getTendanhmuc()}</a></li>
					</c:forEach>	
				</ul>
			</div>
			
			<div class="col-md-8 col-sm-8">		
				<div class="row">
					<div class="col-md-4 col-sm-4">
						<img class="img-chitiet" alt="" src='<c:url value="/resources/Image/HinhSanPhamRoutine/${sanpham.getHinhsanpham()}"/>' />
					</div>
					
					<div class="col-md-8 col-sm-8">
						<h3 id="tensp" data-masp="${sanpham.getMasanpham()}" style="font-weight: 600; font-size: 20px; margin-bottom: 16px">${sanpham.getTensanpham()}</h3>
						<h4 id="giatien" data-value="${sanpham.getGiatien()}" style="font-weight: bold; color:red; font-size: 1.5rem; margin-bottom: 22px">${sanpham.getGiatien()} VND</h4>
						<table class="table">
						
							<thead>
								<tr>									
									<td><h5>Màu sản phẩm</h5></td>
									<td><h5>Size</h5></td>
									<td><h5>Số lượng</h5></td>
								</tr>
							</thead>
							
							<tbody>
								<c:forEach var="chitietsanpham" items="${sanpham.getChitietsanpham()}">
									<tr>									
										<td class="mau" data-mamau="${chitietsanpham.getMausanpham().getMamau()}">${chitietsanpham.getMausanpham().getTenmau()}</td>
										<td class="size" data-masize="${chitietsanpham.getSizesanpham().getMasize()}">${chitietsanpham.getSizesanpham().getSize()}</td>
										<td class="soluong">${chitietsanpham.getSoluong()}</td>
										<td><button data-machitiet="${chitietsanpham.getMachitietsanpham()}" class="btn btn-success btn-giohang">Giỏ hàng</button></td>
									</tr>
								</c:forEach>									
							</tbody>
						</table>
					</div>
				</div>
			</div>
			
			<div class="col-md-2 col-sm-2">
				<span>${sanpham.getMota()}</span>
			</div>
		</div>
	</div>
	

	<div id="footer" class="container-fluid">
		<div class="row">
			<div class="col-sm-4 col-md-4">
				<p><span class="title-footer">INFORMATION</span></p>
				<span>H&M is a prestigious fashion brand, always ensuring the best product quality for customers</span>
			</div>
			
			<div class="col-sm-4 col-md-4">
				<p><span class="title-footer">CONTACT</span></p>
				<span>192 - 194 Hoa Lan, Phường 2, Quận Phú Nhuận, TP Hồ Chí Minh</span>
				<div style="margin-top: 6px;"><span >Email: junhuy199931@gmail.com</span></div>
				<div style="margin-top: 6px;"><span>Hotline: 0906630448</span></div>
			</div>
			
			<div class="col-sm-4 col-md-4">
				<p><span class="title-footer">FEEDBACK</span></p>
				<form action="" method="post">
					<input name="tenNhanVien" class="material-textinput" style="margin-bottom: 6px" type="text" placeholder="Email"/>
					<textarea name="tuoi" rows="4" cols="50" placeholder="Text here..."></textarea>
					<button class="material-primary-button" style="background-color: #a9a94b">SUBMIT</button>
				</form>
				
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>