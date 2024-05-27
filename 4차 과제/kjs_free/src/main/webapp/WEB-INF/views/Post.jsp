<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../resources/styles.css">
<meta charset="UTF-8">
<title>Post</title>
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
					<li class="nav-item"><a class="nav-link active" href="/member/myAccount">${sessionScope.id}님</a></li>
					<li class="nav-item"><a class="nav-link" href="/member/logout">로그아웃</a></li>
					</c:if>
					<li class="nav-item"><a class="nav-link" href="/post/newPost">새 글 작성</a></li>
					<li class="nav-item"><a class="nav-link" href="/member/Home">홈으로</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container mt-5">
		<header class="mb-4">
			<h1 class="fw-bolder mb-1">${ post.post_title }</h1><br>
			<div class="text-muted fst-italic mb-2">작성자 : ${ nick } | 포스팅날짜 : ${ post.post_uploadtime }</div>
			<c:if test="${ sessionScope.id eq post.mem_id }">
			<a class="badge bg-secondary text-decoration-none link-light" href="http://localhost:8080/post/postUpdate?post_num=${ post.post_num }" target="_self"> 수정 </a>
			<a class="badge bg-secondary text-decoration-none link-light" href="http://localhost:8080/kangjinhyuk_free/PostServlet?cmd=delete&post_num=${ post.post_num }" > 삭제 </a>
			</c:if>
		</header>
		<br><div><pre class="mb-5">${ post.post_content }</pre></div>
	</div>
</body>
</html>