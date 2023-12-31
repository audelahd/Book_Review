<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>

<head>
<meta charset="UTF-8">
<title>책보기</title>
<link rel="stylesheet" href="../assets/css/main.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function backToList(obj) {
		obj.action = "${contextPath}/book/listBooks.do";
		obj.submit();
	}
	
	 function reviewArticle(url, booktitle_){
		 var form = document.createElement("form");
		 form.setAttribute("method", "post");
		 form.setAttribute("action", url);
	     var booktitle_Input = document.createElement("input");
	     booktitle_Input.setAttribute("type","hidden");
	     booktitle_Input.setAttribute("name","booktitle_");
	     booktitle_Input.setAttribute("value", booktitle_);
		 
	     form.appendChild(booktitle_Input);
	     document.body.appendChild(form);
	     form.submit();
	 }


	function fn_articleForm(isLogOn, articleForm, loginForm) {
		if (isLogOn != '' && isLogOn != 'false') {
			location.href = articleForm;
		} else {
			alert("로그인 후 글쓰기가 가능합니다.")
			location.href = loginForm
					+ '?action=/board/articleForm.do?booktitle=${book.booktitle}';
		}
	}
</script>

<style>
.second {
	padding-top: 50px;
	align: center;
	width: 80%;
}

#test {
	padding-bottom: 50px;
}

li {
	margin: 0;
	padding: 0;
}

ul {
	margin: 0;
	padding: 0;
	display: flex;
	list-style: none;
}

.container {
	width: 900px;
} /*폭을 일정하게 담기 위한 css*/
.coffeename {
	font-size: 20px;
	font-weight: bold;
	margin-bottom: 0;
}

.coffeename2 {
	font-size: 13px;
	margin-top: 3px;
	padding-bottom: 5px;
}

.seconddetail {
	padding-top: 17px;
	border-top: 3px solid black;
	font-size: 13px;
	font-weight: bold;
	padding-bottom: 30px;
	border-bottom: 1px solid lightgray;
	margin: 0;
}

.productdetail {
	display: flex;
	justify-content: space-between;
	border-bottom: 1px solid lightgray;
	padding-top: 20px;
	padding-bottom: 20px;
	margin: 0;
}

.productdetail span {
	margin-left: 12px;
	margin-right: 12px;
	font-size: 17px;
	font-weight: bold;
	margin-bottom: 0;
}
</style>
</head>
<body>
	<form>
		<table>
			<div class="container" align="center">


				<div class="second">
					<div id="fifth">
						<div class="emojiright">
							<p class="coffeename">${book.booktitle}</p>
							<p class="coffeename2">${book.bookwriter}/<a
									href="${contextPath }/book/genreSearch.do?genre=${book.genre}">
									${book.genre }</a>
							</p>
						</div>

					</div>

					<p class="seconddetail">책 정보</p>
					<p class="seconddetail">${book.bookinfo }</p>

					<div class="productdetail">
						<span>보류</span> <span>보류2</span>
					</div>



				</div>
			</div>
			
			
			<tr id="tr_btn">	<td colspan="2" align="center">
			
			<input type=button value="리스트로 돌아가기" onClick="backToList(this.form)" /> </td>
		</tr>


		</table>
		
	</form>
	
	<form action="${contextPath }/board/articleForm.do">
	<div align ="center" id ="test">
		<input type="hidden" name="booktitle" value="${ book.booktitle }">
		<button type="submit">이 책의 리뷰 작성</button>
		
		<input type=button value="이 책의 리뷰 조회"
							onClick="location.href='${contextPath}/board/listReviews.do?booktitle_=${book.booktitle }'"/>
		
		
	</div>
	</form>
</body>
</html>