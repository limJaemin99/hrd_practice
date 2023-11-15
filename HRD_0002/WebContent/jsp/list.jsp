<%@page import="dto.StudentDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생목록</title>
<link rel="styleSheet" href="../css/layout.css">
<link rel="styleSheet" href="../css/list.css">
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<section>
	<h1>학생목록</h1>
	<table>
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>학년</th>
			<th>반</th>
			<th>번호</th>
			<th>성별</th>
			<th>전화번호</th>
			<th>주소</th>
		</tr>
		<%
			StudentDAO dao = new StudentDAO();
			List<StudentDTO> list = dao.getList();
			
			for(StudentDTO dto : list){
		%>
		<tr>
			<td><%= dto.getSno() %></td>
			<td><%= dto.getSname() %></td>
			<td><%= dto.getGrade() %></td>
			<td><%= dto.getS_class() %></td>
			<td><%= dto.getNum() %></td>
			<td><%= dto.getSgender() %></td>
			<td><%= dto.getSphone() %></td>
			<td><%= dto.getSaddress() %></td>
		</tr>
		<%
			}
		%>
	</table>
</section>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>