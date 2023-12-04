<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="styleSheet" href="css/layout.css">
</head>
<body>
<header>
	<h2>(과정평가형 정보처리산업기사) 백신예약 프로그램 ver.202109</h2>
</header>
<nav>
	<ul>
		<li><a href="<%= request.getContextPath()%>/reserveView.jsp">백신예약</a></li>
		<li><a href="<%= request.getContextPath()%>/searchView.jsp">백신예약조회</a></li>
		<li><a href="<%= request.getContextPath()%>/currentView.jsp">백신예약현황</a></li>
		<li><a href="<%= request.getContextPath()%>/index.jsp">홈으로</a></li>
	</ul>
</nav>
</body>
</html>