<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body id="body-login">

	<div id="body-flex-login">
		<div id="container-login">

			<div id="container-login-left">
				<div id="header-top-left" class="header-login">
					<span id="text-logo">Welcome</span> <br /> <span
						id="hint-text-logo">Hãy tạo nên phong cách của bạn cùng
						Minishop</span>
				</div>

				<div id="header-bottom-left">
					<p>
						<img alt="icon_oval" src='<c:url value="/resources/Image/circle.png"/>'/>
						<span>Luôn cập nhật xu hướng thời trang mới nhất</span>
					</p>
					<p>
						<img alt="icon_oval" src='<c:url value="/resources/Image/circle.png"/>'/>
						<span>Giảm hơn 50% tất cả các mặt hàng dành cho khách vip</span>
					</p>
					<p>
						<img alt="icon_oval" src='<c:url value="/resources/Image/circle.png"/>'/>
						<span>Tận tình tư vấn để tạo nên phong cách của bạn</span>
					</p>
				</div>
			</div>

			<div id="container-login-right">
				<div id="header-top-right" class="header-login">
					<span class="actived" id="dangnhap">Đăng nhập</span> / <span id="dangky">Đăng ký</span>
				</div>
				
				<div id="container-center-login-right">
						<div class="container-login-form" id="container-center-login-right">
							<input id="email" name="email" class="material-textinput input-icon-email" placeholder="Email" type="text"/> <br/>
							<input id="matkhau" name="matkhau" class="material-textinput input-icon-password" placeholder="Password" type="text"/> <br/>
							<input id="btnDangNhap" class="material-primary-button" type="submit" value="LOGIN"/> <br/>
						</div>
						
						<div class="container-register-form" id="container-center-login-right">
							<form action="" method="post">
								<input id="email" name="email" class="material-textinput input-icon-email" placeholder="Email" type="Email"/> <br/><p></p>
								<input id="matkhau" name="matkhau" class="material-textinput input-icon-password" placeholder="Password" type="password"/> <br/><p></p>
								<input id="nhaplaimatkhau" name="nhaplaimatkhau" class="material-textinput input-icon-password" placeholder="Password again" type="password"/> <br/>
								<input id="btnDangNhap" class="material-primary-button" type="submit" value="SIGN UP"/> <br/>
							</form>		
						</div>
						
						<span id="ketqua"></span>
						<span>${kiemtradangnhap}</span>
				</div>
				
				<div id="container-social-login">
						<a href="https://www.facebook.com/huyhoangle3101/"><img id="icon-facebook" alt="icon_facebook" src='<c:url value="/resources/Image/facebook.png" />' /></a>
						<a href="https://www.facebook.com/huyhoangle3101/"><img alt="icon_google" src='<c:url value="/resources/Image/search.png" />' /></a>
				</div>

			</div>

		</div>
	</div>

</body>

<jsp:include page="footer.jsp"></jsp:include>
</html>