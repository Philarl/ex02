<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/product/pro_insert">
		상품이름 : <input type="text" name="pro_name"><br>
		상품설명 : <input type="text" name="pro_desc"><br>
		<input type="submit" value="글저장하기">
	</form>
</body>
</html>