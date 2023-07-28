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
<meta charset="UTF-8">


<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../assets/css/main.css">
<title>글목록창</title>
</head>
<script>
	function fn_articleForm(isLogOn, articleForm, loginForm) {
		if (isLogOn != '' && isLogOn != 'false') {
			location.href = articleForm;
		} else {
			alert("로그인 후 글쓰기가 가능합니다.")
			location.href = loginForm + '?action=/board/articleForm.do';
		}
	}
</script>
<body>
	<table border="1" width="80%" class ="default">
		<tr align="center" height="10"  >
			<td>글 번호</td>
			<td>책 제목</td>
			<td>별점</td>
			<td>추천 수</td>
			<td>작성자</td>
			<td>작성일</td>
		
		</tr>
		<c:choose>
			<c:when test="${articlesList ==null }">
				<tr height="10">
					<td colspan="4">
						<p align="center">
							<b><span style="font-size: 9pt;">등록된 글이 없습니다.</span></b>
						</p>
					</td>
				</tr>
			</c:when>
			<c:when test="${articlesList !=null }">
				<c:forEach var="article" items="${articlesList }"
					varStatus="articleNum">
					<tr align="center">
						<td width="10%">${articleNum.count}</td>
						<td width="20%"><a
							href="${contextPath}/board/viewArticle.do?articleNO=${article.articleNO}">${article.booktitle_ }</a>
						</td>
						<td width="10%">${article.staring}</td>
						<td width="20%">${article.reco}</td>
						<td width="20%">${article.id}</td>
						<td width="20%">${article.writeDate}</td>
						
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<br><br><br><br><br><br><br>

</body>
</html>