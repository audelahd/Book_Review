<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>list</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css2?family=Dancing+Script&display=swap"
	rel="stylesheet">

<title>헤더</title>
</head>
<body class="homepage is-preload">
	<div id="page-wrapper">


		<div id="header-wrapper">
			<div class="container">

				<!-- Header -->
				<header id="header">
					<div class="inner">

				
						<h1>
							<a href="${contextPath }/home" id="logo">BookReview</a>
						</h1>

				
						<nav id="nav">
							<ul>
								<li><c:choose>
										<c:when test="${isLogOn == true  && member!= null}">
											<a align="center">환영합니다. ${member.name }님!</a>
											<a href="${contextPath}/member/logout.do">로그아웃</a>
										</c:when>
										<c:otherwise>
											<a href="${contextPath}/member/loginForm.do"> 로그인</a>
										</c:otherwise>
									</c:choose></li>
						
								<li><a href="${contextPath}/member/listMembers.do"
									class="no-underline">회원관리</a></li>
								<li><a href="${contextPath}/board/listArticles.do"
									class="no-underline">게시판관리</a></li>
								<li><a href="${contextPath}/book/listBooks.do"
									class="no-underline">상품관리</a></li>
							</ul>
						</nav>

					</div>
				</header>


			</div>
		</div>


	</div>

	<script src="../assets/js/jquery.min.js"></script>
	<script src="../assets/js/jquery.dropotron.min.js"></script>
	<script src="../assets/js/browser.min.js"></script>
	<script src="../assets/js/breakpoints.min.js"></script>
	<script src="../assets/js/util.js"></script>
	<script src="../assets/js/main.js"></script>

</body>
</html>



