<%@page import="java.util.List"%>
<%@page import="dao.PatientDAO"%>
<%@page import="dto.PatientDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지역별검사건수</title>
<link rel="styleSheet" href="../css/layout.css">
<link rel="styleSheet" href="../css/viewTable.css">
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<section>
	<h1>(지역별) 검사건수통계</h1>
	<table>
		<tr>
			<th>지역코드</th>
			<th id="cityName">지역명</th>
			<th>검사건수</th>
		</tr>
		<%
			PatientDAO dao = new PatientDAO();
			List<PatientDTO> list = dao.getTestCountList();
			
			for(PatientDTO dto : list){
		%>
		<tr>
			<td><%= dto.getP_city() %></td>
			<td><%= dto.getCityName() %></td>
			<td><%= dto.getCount() %></td>
		</tr>
		<%
			}
		%>
	</table>
</section>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>