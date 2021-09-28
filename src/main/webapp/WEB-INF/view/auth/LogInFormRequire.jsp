<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인이 필요한 기능입니다. </h2>
<p>로그인 해주세요.</p>
<form action = '../auth/login.do' method ="post" >
이메일: <input type="text" name="email"><br>
암호 : <input type="password" name="password"><br>
<input type="submit" value = "로그인">
<input type="button" value = "취소" 
onclick="location.href='../member/list.do'">

</form>
</body>
</html>