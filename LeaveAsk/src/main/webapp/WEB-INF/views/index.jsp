<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<h2>請假系統</h2>
	<div>
		<form action="login" method="post">
			帳號:<input type="text" name="username" value="${username}howardchen@twcoding.com" /> 密碼:<input
				type="password" name="password" value="${password}123" /> <input
				type="submit" value="登入"> <!-- <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" /> -->
		</form>
	</div>

</body>
</html>
