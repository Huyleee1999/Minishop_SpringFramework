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
	<div id="header" class="container-fluid">
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
							aria-current="page" href="#">TRANG CHỦ</a></li>
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
							aria-current="page" href="#">DỊCH VỤ</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">LIÊN HỆ</a></li>
					</ul>
					
					<ul class="nav navbar-nav navbar-right">
						<c:choose>
							<c:when test="${chucaidau != null }">
								<li class="login-header-text nav-item"><a class="circle-avatar" href="dangnhap/"><span>${chucaidau}</span></a></li>							
							</c:when>
							
							<c:otherwise>
								<li class="login-header-text nav-item"><a href="dangnhap/">ĐĂNG NHẬP</a></li>
							</c:otherwise>
						</c:choose>
						
						<li class="login-header-text nav-item"><a href="dangnhap/">ĐĂNG KÝ</a></li>
						<li><a href="#"><img src="<c:url value="/resources/Image/cart.png" />" /></a></li>
					</ul>
				</div>
			</div>
		</nav>

		<div class="event-header container wow bounceIn">
			<span>TỪ 28/4 ĐẾN 28/5</span> <br /> 
			<span style="font-size: 50px">MUA 1 TẶNG 1</span> <br />
			<button>XEM NGAY</button>
			<br />
		</div>
	</div>

	<div id="info" class="container">
		<div class="row">
			<div class="col-12 col-sm-4 col-md-4 wow fadeInLeft" data-wow-duaration="1s">
				<img class="icon" src='<c:url value="/resources/Image/high-quality.png"/>'/> <br>
				<span style="font-size: 32px; font-weight: 500">QUALITY</span> <br>
				<span style="font-size: 15px">We promise to bring you the best products</span> <br>
			</div>
			
			<div class="col-12 col-sm-4 col-md-4 wow fadeInDown" data-wow-duaration="1s" data-wow-delay="1s">
				<img class="icon" src='<c:url value="/resources/Image/piggy-bank.png"/>'/> <br>
				<span style="font-size: 32px; font-weight: 500">SAVING</span> <br>
				<span style="font-size: 15px">Committed to the cheapest market price to help you save up to 20% for each product</span> <br>
			</div>
			
			<div class="col-12 col-sm-4 col-md-4 wow fadeInRight" data-wow-duaration="1s" data-wow-delay="2s">
				<img class="icon" src='<c:url value="/resources/Image/delivery.png"/>'/> <br>
				<span style="font-size: 32px; font-weight: 500">DELIVERY</span> <br>
				<span style="font-size: 15px">We are committed to same-day delivery to bring products to customers as quickly as possible</span> <br>
			</div>
		</div>
	</div>
	
	<div id="title-product" class="container">
		<span>BEST SELLER</span>
		<div class="row">
		
		<c:forEach var="sanpham" items="${listsanpham}">
			<div class="col-md-3 col-sm-6">
				<a href="chitiet/${sanpham.getMasanpham()}">
					<div class="product wow pulse">
						<img alt="hinh" src='<c:url value="/resources/Image/HinhSanPhamRoutine/${sanpham.getHinhsanpham()}"/>' /> <br>	
						<span class="tee-shirt">${sanpham.getTensanpham()}</span> <br>
						<span class="price">${sanpham.getGiatien()} VNĐ</span>
					</div>
				</a>
			</div>
		</c:forEach>
		
		</div>
	</div>
			<!-- END SAN PHAM -->

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