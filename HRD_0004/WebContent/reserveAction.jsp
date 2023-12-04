<%@page import="dto.VaccresvDTO"%>
<%@page import="dao.VaccresvDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int resvno = Integer.parseInt(request.getParameter("resvno"));
	String jumin = request.getParameter("jumin");
	String hospcode = request.getParameter("hospcode");
	String resvdate = request.getParameter("resvdate");
	int resvtime = Integer.parseInt(request.getParameter("resvtime"));
	String vcode = request.getParameter("vcode");
	
	VaccresvDAO dao = new VaccresvDAO();
	VaccresvDTO dto = new VaccresvDTO(resvno, jumin, hospcode, resvdate, resvtime, vcode);
	
	dao.regist(dto);
	
	System.out.println("실행완료");
	
	out.print("<script>");
	out.print("alert('등록이 완료되었습니다!');");
	out.print("location.href='index.jsp';");
	out.print("</script>");
%>