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
	<h1>백신예약조회</h1>
	<form action="searchAction.jsp" method="post">
		<table>
			<tr>
				<th>예약번호</th>
				<td><input type="text" name="resvno" id="resvno"></td>
			</tr>
			<tr>
				<td colspan="2" id="buttons">
					<button type="button" id="search">조회하기</button>
					<button type="button" onclick="location.href='index.jsp'">홈으로</button>
				</td>
			</tr>
		</table>
	</form>
</section>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript">
	document.getElementById('search').addEventListener('click', function(e) {
		var resvno = document.getElementById('resvno')
		
		if(resvno.value.length == 0){
			alert('예약번호를 입력하세요.');
			resvno.focus();
		} else {
			document.forms[0].submit();
		}
	});
</script>
</body>
</html>