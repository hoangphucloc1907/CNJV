<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý hàng hóa</title>
</head>
<body>
	<div class="container">
		<header>
			<h1>QUẢN LÝ HÀNG HÓA</h1>
		</header>
		<nav>
			<h4>${username}</h4>
			<ul>
				<li><a href="jsp/Login.jsp">Đăng nhập</a></li>
				<li><a href="jsp/SignUp.jsp">Đang ký</a></li>
			</ul>
		</nav>
		<section>
			<div class="level1">
				<center>
					<a href="ProductListServlet"><img src="Images/buttonDanhmuchang.jpg" /></a>
				</center>
			</div>
			<div class="level2">
				<center>
					<a href="#"><img src="Images/buttonNhanvien.jpg" /></a>
				</center>
			</div>
			<div class="vp">
				<center>
					<a href="#"><img src="Images/buttonChungtu.jpg" /></a>
				</center>
			</div>
			<div class="mos">
				<center>
					<a href="#"><img src="Images/buttonThongke.jpg" /></a>
				</center>
			</div>
		</section>
	</div>

</body>
</html>