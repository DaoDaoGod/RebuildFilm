<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/jquery-2.1.1.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="Serach" Method="get">
		<input type="text" name="searchText"> <input type="submit"
			value="提交">
	</form>

	<form action="UserRegister" Method="post">
		<input type="text" name="username"> <input type="text"
			name="password"> <input type="submit" value="注册">
	</form>
	<form action="UserLogin" Method="post">
		<input type="text" name="loginname"> <input type="text"
			name="loginpassword"> <input type="submit" value="登陆">
	</form>

</body>
</html>