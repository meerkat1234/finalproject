<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p> <h2><a href="${pageContext.request.contextPath }/offers"> 학기별 이수학점 조회 </a> </p>
	<p> <a href="${pageContext.request.contextPath }/createoffer"> 수강 신청하기 </a> </p>
	<p> <a href="${pageContext.request.contextPath }/semester?year=2019&semester=1"> 수강 신청 조회  </a></h2> </p>
	
	<c:if test="${pageContext.request.userPrincipal.name != null }">
		<a href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>
	
	<form id="logout" action="<c:url value="/logout" />" method="post">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
	</form>

</body>
</html>

