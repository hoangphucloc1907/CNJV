<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<center>
		<h1>ĐĂNG NHẬP</h1>
		<form method="post" action="${pageContext.request.contextPath}/LoginServlet">
			<table>
				<tr>
					<td>Tên đăng nhập</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Mật khẩu</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td colspan="2"><button>Đăng nhập</button> <input type="reset"
						value="Nhập lại"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>