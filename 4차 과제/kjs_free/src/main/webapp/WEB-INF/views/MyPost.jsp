<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/styles.css">
<meta charset="UTF-8">
<title>MyPost</title>
</head>
<body>
<!--navigation bar-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand">Blog</a>
			<div class="navbar-collapse collapse show">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<c:if test="${sessionScope.id!=null}">
					<li class="nav-item"><a class="nav-link active" href="http://localhost:8080/kangjinhyuk_free/MemberServlet?cmd=myAccount">${sessionScope.id}님</a></li>
					<li class="nav-item"><a class="nav-link" href="http://localhost:8080/kangjinhyuk_free/MemberServlet?cmd=logout">로그아웃</a></li>
					</c:if>
					<li class="nav-item"><a class="nav-link" href="http://localhost:8080/kangjinhyuk_free/PostServlet?cmd=newPost">새 글 작성</a></li>
					<li class="nav-item"><a class="nav-link" href="http://localhost:8080/kangjinhyuk_free/Home.jsp">홈으로</a></li>
				</ul>
			</div>
		</div>
	</nav>
<!--header-->	
	<header class="py-5 bg-light border-bottom mb-4">
		<div class="container">
			<div class="text-center my-5">
            	<h1 class="fw-bolder">My Post</h1>
        	</div>
		</div>
	</header>
	
	<!--page content-->
	<div class="container mt-5">
		<div class="col-lg-12">
			<c:forEach var="post" items="${mypostlist}">
				<div class="card mb-4">
					<div class="card-body">
						<a>${post.post_num}</a> | <a href="${pageContext.request.contextPath}/PostServlet?cmd=post&post_num=${post.post_num}">${post.post_title}</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	
</body>
</html>