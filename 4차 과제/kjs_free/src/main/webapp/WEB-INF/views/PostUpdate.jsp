<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="domain.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../resources/styles.css">
<meta charset="UTF-8">
<title>Post Update</title>
</head>
<body>
	<!--navigation bar-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand">HomePage</a>
			<div class="navbar-collapse collapse show">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<c:if test="${sessionScope.id==null}">
					<li class="nav-item"><a class="nav-link" href="/member/login">로그인</a></li>
					</c:if>
					
					<c:if test="${sessionScope.id!=null}">
					<li class="nav-item"><a class="nav-link active">${sessionScope.id}님</a></li>
					<li class="nav-item"><a class="nav-link" href="/member/logout">로그아웃</a></li>
					</c:if>
					<li class="nav-item"><a class="nav-link" href="/member/Home">홈으로</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container mt-5">
			<form action="/post/postUpdate" method="post">
			<fieldset>
				<legend class="fw-bolder mb-5">Post Update</legend>
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li><h2 class="fw-bolder mb-1">Title</h2><br><input class="col-lg-12" type="text" name="post_title" value=${ post.post_title }></li><br>
					<li><h2 class="fw-bolder mb-1">Content</h2><br><textarea class="col-lg-12" name="post_content">${ post.post_content }</textarea>
				</ul>
				<input type="hidden" name="post_num" value=${ post.post_num }>
			</fieldset>
			<br>
			<fieldset>
				<input type="submit" name="submit" value="최종 수정">
				<input type="reset" name="reset" value="다시 작성">
			</fieldset>
		</form>
	</div>
</body>
</html>