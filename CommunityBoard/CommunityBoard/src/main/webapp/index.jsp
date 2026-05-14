<%@page import="dto.UserDTO"%>
<%@ page language="java"
contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>

<%
UserDTO loginUser=
(UserDTO)session.getAttribute(
        "loginUser");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>

<body>

<% if(loginUser!=null){ %>

<h2>
<%=loginUser.getNickname()%>님 환영합니다
</h2>

<a href="/CommunityBoard/logout">
로그아웃
</a>

<% } else { %>

<h2>로그인 안됨</h2>

<a href=
"/CommunityBoard/views/user/login.jsp">

로그인
</a>

<% } %>

</body>
</html>