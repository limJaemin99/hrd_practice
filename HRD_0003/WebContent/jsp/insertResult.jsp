<%@page import="dto.TestDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.TestDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검사결과입력</title>
<link rel="styleSheet" href="../css/layout.css">
<link rel="styleSheet" href="../css/insertResult.css">
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<section>
	<h1>검사결과입력</h1>
	<form action="insertResultAction.jsp" method="POST">
		<table>
			<tr>
				<th>환자번호</th>
				<td><input type="text" name="p_no" id="p_no"> 예)1001</td>
			</tr>
			<tr>
				<th>검사코드</th>
				<td>
					<select name="code" id="code">
						<option value="">검사명</option>
						<%
							TestDAO dao = new TestDAO();
							List<TestDTO> list = dao.getList();
							
							for(TestDTO dto : list){
						%>
						<option value="<%= dto.getT_code() %>"><%= dto.getT_full() %></option>
						<%
							}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<th>검사시작일자</th>
				<td><input type="text" name="sdate" id="sdate"> 예)20200101</td>
			</tr>
			<tr>
				<th>검사상태</th>
				<td>
					<input type="radio" name="status" value="1" id="status1">검사중
					<input type="radio" name="status" value="2" id="status2">검사완료
				</td>
			</tr>
			<tr>
				<th>검사완료일자</th>
				<td><input type="text" name="ldate" id="ldate"> 예)20200101</td>
			</tr>
			<tr>
				<th>검사결과</th>
				<td>
					<input type="radio" name="result" value="X" id="resultX">미입력
					<input type="radio" name="result" value="P" id="resultP">양성
					<input type="radio" name="result" value="N" id="resultN">음성
				</td>
			</tr>
			<tr>
				<td colspan="2" id="buttons">
					<button type="button" id="regist">검사결과등록</button>
					<button type="reset" id="reset">다시쓰기</button>
				</td>
			</tr>
		</table>
	</form>
</section>
<jsp:include page="../footer.jsp"></jsp:include>
<script type="text/javascript">
	document.getElementById('regist').addEventListener('click',function(e){
		var p_no = document.getElementById('p_no').value
		var code = document.getElementById('code').value
		var sdate = document.getElementById('sdate').value
		var status1 = document.getElementById('status1')
		var status2 = document.getElementById('status2')
		var ldate = document.getElementById('ldate').value
		var resultX = document.getElementById('resultX')
		var resultP = document.getElementById('resultP')
		var resultN = document.getElementById('resultN')
		
		var isCheckedStatus = false;
		var isCheckedResult = false;
		
		if(status1.checked || status2.checked) isCheckedStatus = true;
		if(resultX.checked || resultP.checked || resultN.checked) isCheckedResult = true;
		
		if(p_no.length == 0){
			alert('환자번호가 입력되지 않았습니다!')
			document.getElementById('p_no').focus()
		} else if(code == '') alert('검사코드가 선택되지 않았습니다!')
		else if(sdate.length == 0) alert('검사시작일자가 입력되지 않았습니다!')
		else if(!isCheckedStatus) alert('검사상태가 선택되지 않았습니다!')
		else if(ldate.length == 0) alert('검사완료일자가 입력되지 않았습니다!')
		else if(!isCheckedResult) alert('검사결과가 선택되지 않았습니다!')
		else {
			alert('검사결과가 정상적으로 등록되었습니다!')
			document.forms[0].submit()
		}
	})

	document.getElementById('reset').addEventListener('click',function(e){
		alert('정보를 지우고 처음부터 다시 입력 합니다!')
		document.getElementById('p_no').focus()
	})
</script>
</body>
</html>