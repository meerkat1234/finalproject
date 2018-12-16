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

	<table>
		<tr> 
			<td>년도</td>  
			<td>학기</td> 
			<td>이수 학점</td> 
			<td>상세보기</td> 
		</tr>
		<tr> 
			<td>${fourone.year}</td>  
			<td>${fourone.semester}</td> 
			<td>${fourone.totalGrade}</td> 
			<td><a href="/helloSpringMVC/semester?year=2016&semester=1">링크</a></td> 
		</tr>
		<tr> 
			<td>${fourtwo.year}</td>  
			<td>${fourtwo.semester}</td> 
			<td>${fourtwo.totalGrade}</td> 
			<td><a href="/helloSpringMVC/semester?year=2016&semester=2">링크</a></td> 
		</tr>
		<tr> 
			<td>${fiveone.year}</td>  
			<td>${fiveone.semester}</td> 
			<td>${fiveone.totalGrade}</td> 
			<td><a href="/helloSpringMVC/semester?year=2017&semester=1">링크</a></td> 
		</tr>
		<tr> 
			<td>${seventwo.year}</td>  
			<td>${seventwo.semester}</td> 
			<td>${seventwo.totalGrade}</td> 
			<td><a href="/helloSpringMVC/semester?year=2017&semester=2">링크</a></td> 
		</tr>
		<tr> 
			<td>${eightone.year}</td>  
			<td>${eightone.semester}</td> 
			<td>${eightone.totalGrade}</td> 
			<td><a href="/helloSpringMVC/semester?year=2018&semester=1">링크</a></td> 
		</tr>
	</table>


</body>
</html>