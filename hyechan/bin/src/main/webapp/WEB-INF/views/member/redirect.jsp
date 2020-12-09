<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Edit Redirect</title>
<script type="text/javascript" src="/cls/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#frm').submit();
	});
</script>
</head>
<body>
	<form method="POST" action="/cls/member/memberInfo.cls" id="frm">
		<input type="hidden" name="id" value="${ID}">
		<input type="hidden" name="msg" value="${MSG}">
	</form>
</body>
</html>