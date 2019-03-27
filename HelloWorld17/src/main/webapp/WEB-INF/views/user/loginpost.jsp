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
	  
	  <div class="row">
<%--	첫번째방법

 	  	<c:if test="${empty vo }">
	  		<c:redirect url="/user/login"></c:redirect>
	  	</c:if>
	  	<c:if test="${not empty vo }">
	  		<c:redirect url="/"></c:redirect>
	  	</c:if> --%>
	  </div>
	  
	  
	  </div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function() {
			// 두번째방법
			if(${vo==null}) { 
				self.location="/user/login";
			} // 성공은 인터셉트로 구현
		
		});
	</script>
</body>
</html>