<%@page import="dao.ExamDAO"%>
<%@page import="dto.ExamDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//파라미터 값 dto에 저장하기
	ExamDTO dto = new ExamDTO(
			request.getParameter("sno"),
			Integer.parseInt(request.getParameter("ekor")),
			Integer.parseInt(request.getParameter("emath")),
			Integer.parseInt(request.getParameter("eeng")),
			Integer.parseInt(request.getParameter("ehist")));
	
	//insert 메소드 실행
	ExamDAO dao = new ExamDAO();
	dao.insert(dto);
	
	//location.href 로 화면 전환
	out.print("<script>");
	out.print("location.href='../index.jsp'");
	out.print("</script>");
%>