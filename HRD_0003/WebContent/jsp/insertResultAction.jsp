<%@page import="dto.ResultDTO"%>
<%@page import="dao.ResultDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ResultDAO dao = new ResultDAO();
	String p_no = request.getParameter("p_no");
	String t_code = request.getParameter("code");
	String t_sdate = request.getParameter("sdate");
	String t_status = request.getParameter("status");
	String t_ldate = request.getParameter("ldate");
	String t_result = request.getParameter("result");
	
	ResultDTO dto = new ResultDTO(p_no, t_code, t_sdate, t_status, t_ldate, t_result);
	
	dao.insert(dto);
	
	out.println("<script>");
	out.println("location.href='../index.jsp'");
	out.println("</script>");
%>