<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<h2>유저정보 입력</h2>
<form:form commandName="UserInfoVO" action="${root}/user/insert" method="post">
이름 : <input type="text" name="uiName" id="uiName" value="${UserInfoVO.uiName}"><br>
아이디 : <input type="text" name="uiId" id="uiId" value="${UserInfoVO.uiId}"><br>
이메일 : <input type="text" name="uiEmail" id="uiEmail" value="${UserInfoVO.uiEmail}"><br>
<button>유저정보 추가</button>
<a href="${root}/user/userlist"><button type="button">리스트돌아가기</button></a>
</form:form>
</body>
</html>