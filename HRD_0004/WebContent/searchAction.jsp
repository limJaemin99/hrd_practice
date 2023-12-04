<%@page import="dto.SearchDTO"%>
<%@page import="dao.VaccresvDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>백신예약 프로그램</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
	int resvno = Integer.parseInt(request.getParameter("resvno"));
	VaccresvDAO dao = new VaccresvDAO();
	int isReserved = dao.isReserved(resvno);
%>

<%
	if(isReserved == 0) {	//조회 결과 없음 X
%>
<section style="text-align: center;">
	<h1>예약번호 [<%= resvno %>] 로 조회된 결과가 없습니다.</h1>
	<button type="button" onclick="location.href='index.jsp'">홈으로</button>
</section>
<%
	}

	if(isReserved == 1) {	//조회 결과 있음 O
		SearchDTO dto = dao.getReserveInfo(resvno);
%>
<section style="text-align: center;">
	<h1>예약번호 [<%= resvno %>] 님의 예약 조회</h1>
	<table>
		<tr>
			<th>예약번호</th>
			<th>성명</th>
			<th>성별</th>
			<th>병원이름</th>
			<th>예약날짜</th>
			<th>예약시간</th>
			<th>백신코드</th>
			<th>병원지역</th>
		</tr>
		<tr>
			<td><%= dto.getResvno() %></td>
			<td><%= dto.getName() %></td>
			<td><%= dto.getGender() %></td>
			<td><%= dto.getHospname() %></td>
			<td><%= dto.getResvdate() %></td>
			<td><%= dto.getResvtime() %></td>
			<td><%= dto.getVcode() %></td>
			<td><%= dto.getHospaddr() %></td>
		</tr>
	</table>
	<button type="button" style="margin-top: 20px;" onclick="location.href='searchView.jsp'">돌아가기</button>
</section>
<%
	}
%>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>