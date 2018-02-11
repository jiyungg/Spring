<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<title>유저리스트</title>
</head>
<style>
		div#simpleLog {
			height: 200px;
			font-family: Roboto, Arial, Helvetica;
			font-size: 14px;
			color: #404040;
			overflow: auto;
		}
	</style>
<script>
</script>
<body>	
<div class="container">
<table data-toggle="table" id="userTable1" >
	<thead>
		<tr>
			<th data-field="uiNo">번호</th>
			<th data-field="uiName">이름</th>
			<th data-field="uiId">아이디</th>
			<th data-field="uiEmail">이메일</th>
		</tr> 
	</thead>
</table>

<table data-toggle="table" id="userTable2" >
	<thead>
		<tr>
			<th data-field="uiNo">번호</th>
			<th data-field="uiName">이름</th>
			<th data-field="uiId">아이디</th>
			<th data-field="uiEmail">이메일</th>
		</tr> 
	</thead>
</table>
<button type="button">수정</button>
<button type="button">삭제</button>
</body>
</html>