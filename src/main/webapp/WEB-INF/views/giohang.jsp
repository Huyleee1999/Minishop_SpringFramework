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
							aria-current="page" href='<c:url value="/" />'>TRANG CHỦ</a></li>
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
							aria-current="page" href='<c:url value="/" />'>DỊCH VỤ</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href='<c:url value="/" />'>LIÊN HỆ</a></li>
					</ul>
					
					<ul class="nav navbar-nav navbar-right">
						<li class="login-header-text nav-item"><a href="dangnhap/">ĐĂNG NHẬP ${chucaidau}</a></li>
						<li class="login-header-text nav-item"><a href="#">ĐĂNG KÝ</a></li>
						
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
		 <div class="row">
		 	<div class="col-md-6 col-sm-12">
			 	<h3>Danh sách sản phẩm trong giỏ hàng</h3>
			 		<table class="table">
			 			<thead>
			 				<tr>									
								<td><h5>Tên sản phẩm</h5></td>
								<td><h5>Màu sản phẩm</h5></td>
								<td><h5>Size</h5></td>
								<td><h5>Số lượng</h5></td>
								<td><h5>Giá tiền</h5></td>
							</tr>
			 			</thead>
			 		
			 			<tbody>
			 				<c:forEach var="value" items="${giohangs}">
								<tr data-machitiet="${value.getMachitiet() }">
									<td class="tensp" data-masp="${value.getMasp()}">${value.getTensp()}</td>									
									<td class="mau" data-mamau="${value.getMamau()}">${value.getTenmau()}</td>
									<td class="size" data-masize="${value.getMasize()}">${value.getTensize()}</td>
									<td class="soluong"><input min="1" class="soluong-giohang" type="number" value="${value.getSoluong()}"></td>
									<td class="giatien" data-value="${value.getGiatien()}">${value.getGiatien()}</td>
									<td class="xoa-giohang btn btn-outline-danger">Xóa</td>
								</tr>
			 				</c:forEach>
			 			</tbody>
			 		</table>
			 		<h4>Tổng tiền: <span id="tongtien" style="color: red">1.500.000</span></h4>
		 		</div>
		 		
		 	<div class="col-md-6 col-sm-12">
		 		<h3>Thông tin người nhận / người mua</h3>
		
				<div class="form-group">
					<form action="#" method="post">
						<label for="tenkhachhang">Tên người mua / nhận</label>
						<input name="tenkhachhang" id="tenkhachhang" class="form-control" type="text"/> <br>
					
						<label for="sodt">Điện thoại liên lạc</label>
						<input name="sodt" id="sodt" class="form-control" type="text"/> <br>
					
						 <div class="form-check">
						  	<label class="form-check-label">
						    	<input checked="" type="radio" class="form-check-input" name="hinhthucgiaohang" value="Giao hàng tận nơi" >Giao hàng tận nơi
						  	</label> <br>
						 </div>
					 
						 <div class="form-check">
						  	<label class="form-check-label">
						    	<input type="radio" class="form-check-input" name="hinhthucgiaohang" value="Nhận hàng tại cửa hàng">Nhận hàng tại cửa hàng
						  	</label> <br>
						</div>
					 
						<label for="diachigiaohang">Địa chỉ nhận hàng</label>
						<input name="diachigiaohang" id="diachigiaohang" class="form-control" type="text"/> <br>
					 
						<label for="ghichu">Ghi chú</label>
	  					<textarea name="ghichu" class="form-control" rows="5" id="ghichu"></textarea> <br>
					
						<input type="submit" class="btn btn-primary" value="Đặt hàng"/>
					</form>
				</div>
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