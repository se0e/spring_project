<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<div class="container">
	  <div class="row">
	  	<h2>로그인화면임당</h2>
	  	<form action="/user/loginpost" method="post">
	  		<div class="form-group">
		  		<label for="userId">아이디</label>
		  			<input class="form-control" id="userId" name="userId"><br>
		  		<label for="userPw">패스워드</label>
		  			<input class="form-control" id="userPw" name="userPw" type="password">
	  		</div>
	  	</form>
	  	
	  	<div class="form-group">
	  		<button class="btn btn-success form-control" type="submit">로그인</button>
	  	</div>
	  	
	  </div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$("button[type='submit']").click(function() {
				$("form").submit();
			});
		});
	</script>
</body>
</html>