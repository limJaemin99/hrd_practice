<%@page import="dto.CurrentDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.VaccresvDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>백신예약 프로그램</title>
<link rel="styleSheet" href="css/table_cols3.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<section>
	<h1>백신예약현황</h1>
	<table>
		<tr>
			<th>병원지역</th>
			<th>병원지역명</th>
			<th>접종예약건수</th>
		</tr>
		<%
			VaccresvDAO dao = new VaccresvDAO();
			List<CurrentDTO> list = new ArrayList<>();
			list = dao.getCurrentView();
			
			int total = 0;
			
			for(CurrentDTO dto : list) {
				total += dto.getCounts();
		%>
		<tr>
			<td><%= dto.getHospaddr() %></td>
			<td><%= dto.getAddrname() %></td>
			<td><%= dto.getCounts() %></td>
		</tr>
		<%
			}
		%>
		<tr>
			<th colspan="2">총합</th>
			<td><%= total %></td>
		</tr>
	</table>
</section>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>