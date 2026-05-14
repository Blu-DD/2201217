<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>

<body>

<h2>회원가입</h2>

<form action="/CommunityBoard/register"
method="post">

아이디 :
<input type="text" name="username">
<br><br>

비밀번호 :
<input type="password" name="password">
<br><br>

닉네임 :
<input type="text" name="nickname">
<br><br>

이메일 :
<input type="email" name="email">
<br><br>

<input type="submit" value="회원가입">

</form>

</body>
</html>