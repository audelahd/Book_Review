<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%-- 
<c:set var="article"  value="${articleMap.article}"  />
<c:set var="imageFileList"  value="${articleMap.imageFileList}"  />

 --%>
<%
request.setCharacterEncoding("UTF-8");
%>

<head>
<meta charset="UTF-8">
<title>글보기</title>
<style>
#tr_file_upload {
	display: none;
}

#tr_btn_modify {
	display: none;
}



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
	margin-bottom: 5px;
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
justify-content: space-between;
	display: flex;
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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
     function backToList(obj){
	    obj.action="${contextPath}/board/listArticles.do";
	    obj.submit();
     }
 
	 function fn_enable(obj){
		// document.getElementById("i_title").disabled=false;
		 document.getElementById("i_content").disabled=false;
		 document.getElementById("i_staring").disabled=false;
		 document.getElementById("tr_btn_modify").style.display="block";
		 document.getElementById("tr_file_upload").style.display="block";
		 document.getElementById("tr_btn").style.display="none";
	 }
	 
	 function fn_modify_article(obj){
		 obj.action="${contextPath}/board/modArticle.do";
		 obj.submit();
	 }
	 
	 
	 function fn_remove_article(url,articleNO){
		 var form = document.createElement("form");
		 form.setAttribute("method", "post");
		 form.setAttribute("action", url);
	     var articleNOInput = document.createElement("input");
	     articleNOInput.setAttribute("type","hidden");
	     articleNOInput.setAttribute("name","articleNO");
	     articleNOInput.setAttribute("value", articleNO);
		 
	     form.appendChild(articleNOInput);
	     document.body.appendChild(form);
	     form.submit();
	 
	 }
	 
	 function reco_article(url, articleNO){
		 var form = document.createElement("form");
		 form.setAttribute("method", "post");
		 form.setAttribute("action", url);
	     var articleNOInput = document.createElement("input");
	     articleNOInput.setAttribute("type","hidden");
	     articleNOInput.setAttribute("name","articleNO");
	     articleNOInput.setAttribute("value", articleNO);
		 
	     form.appendChild(articleNOInput);
	     document.body.appendChild(form);
	     form.submit();
	 }
	 
	 function fn_reply_form(url, parentNO){
		 var form = document.createElement("form");
		 form.setAttribute("method", "post");
		 form.setAttribute("action", url);
	     var parentNOInput = document.createElement("input");
	     parentNOInput.setAttribute("type","hidden");
	     parentNOInput.setAttribute("name","parentNO");
	     parentNOInput.setAttribute("value", parentNO);
		 
	     form.appendChild(parentNOInput);
	     document.body.appendChild(form);
		 form.submit();
	 }
	 
	 function readURL(input) {
	     if (input.files && input.files[0]) {
	         var reader = new FileReader();
	         reader.onload = function (e) {
	             $('#preview').attr('src', e.target.result);
	         }
	         reader.readAsDataURL(input.files[0]);
	     }
	 }  
 </script>

<link rel="stylesheet" href="../assets/css/main.css">
</head>
<body>
	<form name="frmArticle" method="post" action="${contextPath}"
		enctype="multipart/form-data">
		<table>
			<div class="container" align="center">


				<div class="second">
					<div id="fifth">
						<div class="emojiright">
							<p class="coffeename">${article.booktitle_} - 후기</p>
							<p class="coffeename2">${article.articleNO} / 작성자 : ${article.id}
							</p>
						</div>

					</div>

					<p class="seconddetail">리뷰 내용</p>
					<p class="seconddetail">${article.content }</p>

					<div class="productdetail">
						<span>별점 : ${article.staring } </span><span> 추천 수 : ${article.reco }</span>
					</div>
					
					<div> <p class ="coffeename">${article.writeDate}</p></div>



				</div>
			</div>
			
			<tr id="tr_btn_modify" align="center">
				<td colspan="2"><input type=button value="수정반영하기"
					onClick="fn_modify_article(frmArticle)"> <input type=button
					value="취소" onClick="backToList(frmArticle)"></td>
			</tr>
			
			<tr id="tr_btn">
				<td colspan="2" align="center"><c:if
						test="${member.id == article.id }">
						<input type=button value="수정하기" onClick="fn_enable(this.form)">
						<input type=button value="삭제하기"
							onClick="fn_remove_article('${contextPath}/board/removeArticle.do', ${article.articleNO})">
					</c:if> <input type=button value="리스트로 돌아가기"
					onClick="backToList(this.form)"></td>
			</tr>

		</table>
	</form>
	
	<form method="post" action="${contextPath}/board/recoUp.do"
		name="recform">

		<table>
			<tr>
				<td colspan=5 align="center">
				<input type=button value="추천"
							onClick="fn_remove_article('${contextPath}/board/recoUp.do', ${article.articleNO})">
			</tr>

		</table>
	</form>
	
	
</body>
</html>