<%@page import="dao.VaccresvDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>백신예약 프로그램</title>
<link rel="styleSheet" href="css/table_cols2.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<section>
	<h1>백신 예약</h1>
	<%
		VaccresvDAO dao = new VaccresvDAO();
		int resvno = dao.getResvNo();
	%>
	<form action="reserveAction.jsp" method="post">
		<table>
			<tr>
				<th>예약번호</th>
				<td><input type="text" name="resvno" value="<%= resvno %>" readonly></td>
			</tr>
			<tr>
				<th>주민번호</th>
				<td><input type="text" name="jumin" id="jumin"> 예)790101-1111111</td>
			</tr>
			<tr>
				<th>백신코드</th>
				<td>
					<select name="vcode" id="vcode">
						<option value="">선택</option>
						<option value="V001">A백신</option>
						<option value="V002">B백신</option>
						<option value="V003">C백신</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>병원코드</th>
				<td>
					<input type="radio" name="hospcode" id="hosp1" value="H001">가_병원
					<input type="radio" name="hospcode" id="hosp2" value="H002">나_병원
					<input type="radio" name="hospcode" id="hosp3" value="H003">다_병원
					<input type="radio" name="hospcode" id="hosp4" value="H004">라_병원
				</td>
			</tr>
			<tr>
				<th>예약날짜</th>
				<td><input type="text" name="resvdate" id="resvdate"> 예)20210101</td>
			</tr>
			<tr>
				<th>예약시간</th>
				<td><input type="text" name="resvtime" id="resvtime"> 예)0930, 1130</td>
			</tr>
			<tr>
				<td colspan="2" id="buttons">
					<button type="button" id="regist">등록</button>
					<button type="button" id="cancle">취소</button>
				</td>
			</tr>
		</table>
	</form>
</section>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript">
	document.getElementById('regist').addEventListener('click', function(e) {
		var jumin = document.getElementById('jumin')
		var vcode = document.getElementById('vcode')
		var hosp1 = document.getElementById('hosp1')
		var hosp2 = document.getElementById('hosp2')
		var hosp3 = document.getElementById('hosp3')
		var hosp4 = document.getElementById('hosp4')
		var isChecked = false;
		var resvdate = document.getElementById('resvdate')
		var resvtime = document.getElementById('resvtime')
		
		if(hosp1.checked || hosp2.checked || hosp3.checked || hosp4.checked) isChecked = true;
		
		if(jumin.value.length == 0){
			alert('주민번호를 입력해주세요.')
			jumin.focus()
		} else if(vcode.value == ''){
			alert('백신코드를 선택해주세요.')
			vcode.focus()
		} else if(!isChecked){
			alert('병원코드를 선택해주세요.')
			hosp1.focus()
		} else if(resvdate.value.length == 0){
			alert('예약날짜를 입력해주세요.')
			resvdate.focus()
		} else if(resvtime.value.length == 0){
			alert('예약시간을 입력해주세요.')
			resvtime.focus()
		} else {
			document.forms[0].submit()
		}
	});
	
	document.getElementById('cancle').addEventListener('click', e=>{
		alert('모든 내용을 초기화합니다.')
		document.forms[0].reset()
	});
</script>
</body>
</html>