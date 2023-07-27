<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<style>

</style>
<meta charset="UTF-8">


<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../assets/css/main.css">
<title>책목록창</title>
</head>
<body>
	<table class =default align="center" border="1" width="80%">
		<tr height="10" align="center" bgcolor="lightgreen">
			<td>번호</td>
			<td>책 제목</td>
			<td>저자</td>
			<td>장르</td>
		</tr>
		<c:choose>
			<c:when test="${booksList ==null }">
				<tr height="10">
					<td colspan="4">
						<p align="center">
							<b><span style="font-size: 9pt;">책이 없습니다.</span></b>
							<h1>책이 없음!!!!!!!!!!!</h1>
						</p>
					</td>
				</tr>
			</c:when>
			<c:when test="${booksList !=null }">
				<c:forEach var="book" items="${booksList }"
					varStatus="booktitle">
					<tr align="center">
						<td width="5%">${booktitle.count}</td>
						<td width="10%">
						<a href="${contextPath }/book/viewBook.do?booktitle=${book.booktitle}">${book.booktitle }</a>
						</td>
						<td width="10%">${book.bookwriter}</td>
						<td width="5%">${book.genre}</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>

</body>
</html>