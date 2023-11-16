<%@page import="dto.ResultDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.ResultDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검사결과조회</title>
<link rel="styleSheet" href="../css/layout.css">
<link rel="styleSheet" href="../css/listTable.css">
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<section>
	<h1>검사결과조회</h1>
	<table>
		<tr>
			<th>환자번호</th>
			<th>환자명</th>
			<th>검사명</th>
			<th>검사시작일</th>
			<th>검사상태</th>
			<th>검사완료일</th>
			<th>검사결과</th>
		</tr>
		<%
			ResultDAO dao = new ResultDAO();
			List<ResultDTO> list = dao.getList();
			
			for(ResultDTO dto : list){
		%>
		<tr>
			<td><%= dto.getP_no() %></td>
			<td><%= dto.getP_name() %></td>
			<td><%= dto.getT_name() %></td>
			<td><%= dto.getT_sdate() %></td>
			<td><%= dto.getT_status() %></td>
			<td><%= dto.getT_ldate() %></td>
			<td><%= dto.getT_result() %></td>
		</tr>
		<%
			}
		%>
	</table>
</section>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>