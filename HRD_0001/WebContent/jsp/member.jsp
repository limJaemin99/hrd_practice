<%@page import="dto.PartyDTO"%>
<%@page import="dao.PartyDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.SQLException"%>
<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보자 조회</title>
<link rel="styleSheet" href="../css/layout.css">
<link rel="styleSheet" href="../css/member.css">
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<section>
	<h1>후보조회</h1>
	<table>
		<tr>
			<th>후보번호</th>
			<th>성명</th>
			<th>소속정당</th>
			<th>학력</th>
			<th>주민번호</th>
			<th>지역구</th>
			<th>대표전화</th>
		</tr>
		
		<% 
			MemberDAO memberDao = new MemberDAO();
			PartyDAO partyDao = new PartyDAO();
			List<MemberDTO> list = memberDao.getList();
			for(int i = 0; i < list.size(); i++) {
				PartyDTO party = partyDao.getTel(list.get(i).getP_code());
				
				String school = list.get(i).getP_school();
				if(school.equals("1")) list.get(i).setP_school("고졸");
				else if(school.equals("2")) list.get(i).setP_school("학사");
				else if(school.equals("3")) list.get(i).setP_school("석사");
				else if(school.equals("4")) list.get(i).setP_school("박사");
				
				//switch 써도 되는데 제 컴퓨터에서 오류나서 if로 대체했습니다.
		%>
		<tr>
			<td><%= list.get(i).getM_no() %></td>
			<td><%= list.get(i).getM_name() %></td>
			<td><%= party.getP_name() %></td>
			<td><%= list.get(i).getP_school() %></td>
			<td><%= list.get(i).getM_jumin().substring(0,6) + "-" + list.get(i).getM_jumin().substring(6)%></td>
			<td><%= list.get(i).getM_city() %></td>
			<td><%= party.getP_tel1() + "-" + party.getP_tel2() + "-" + party.getP_tel3() %></td>
		</tr>
		<%
			}
		%>
	</table>
</section>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>