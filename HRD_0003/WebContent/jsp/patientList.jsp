<%@page import="dto.PatientDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.PatientDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환자조회</title>
<link rel="styleSheet" href="../css/layout.css">
<link rel="styleSheet" href="../css/listTable.css">
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<section>
	<h1>환자조회</h1>
	<table>
		<tr>
			<th>환자번호</th>
			<th>환자성명</th>
			<th>생년월일</th>
			<th>성별</th>
			<th>전화번호</th>
			<th>지역</th>
		</tr>
		<%
			PatientDAO dao = new PatientDAO();
			List<PatientDTO> list = dao.getList();
			
			for(PatientDTO dto : list){
		%>
		<tr>
			<td><%= dto.getP_no() %></td>
			<td><%= dto.getP_name() %></td>
			<td><%= dto.getP_birth() %></td>
			<td><%= dto.getP_gender() %></td>
			<td><%= dto.getP_tel() %></td>
			<td><%= dto.getP_city() %></td>
		</tr>
		<%
			}
		%>
	</table>
</section>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>