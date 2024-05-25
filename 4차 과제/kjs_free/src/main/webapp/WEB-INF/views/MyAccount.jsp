<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../resources/styles.css">
<meta charset="UTF-8">
<title>MyAccount</title>
</head>
<body>
<!--navigation bar-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand">Blog</a>
			<div class="navbar-collapse collapse show">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<c:if test="${sessionScope.id!=null}">
					<li class="nav-item"><a class="nav-link active">${sessionScope.id}님</a></li>
					<li class="nav-item"><a class="nav-link" href="http://localhost:8080/kangjinhyuk_free/MemberServlet?cmd=logout">로그아웃</a></li>
					</c:if>
					<li class="nav-item"><a class="nav-link" href="http://localhost:8080/kangjinhyuk_free/Home.jsp">홈으로</a></li>
				</ul>
			</div>
		</div>
	</nav>
<!--header-->	
	<header class="py-5 bg-light border-bottom mb-4">
		<div class="container">
			<div class="text-center my-5">
            	<h1 class="fw-bolder">My Account</h1>
        	</div>
		</div>
	</header>
	
	<!--page content-->
	<div class="container mt-5">
		<div class="col-lg-12">
			<table >
				<tr class="fw-bolder mb-4"><td>ID</td><td> : ${ member.id }</td></tr>
				<tr class="fw-bolder mb-4"><td>NICKNAME</td><td> : ${ member.nickname }</td></tr>
				<tr class="fw-bolder mb-4"><td>EMAIL</td><td> : ${ member.email }</td></tr>
			</table>
		</div>
		<br>
		<a class="badge bg-secondary text-decoration-none link-light" href="http://localhost:8080/kangjinhyuk_free/MemberServlet?cmd=update" target="_self"> 수정 </a>
		<a class="badge bg-secondary text-decoration-none link-light" href="http://localhost:8080/kangjinhyuk_free/MemberServlet?cmd=delete" target="_self"> 회원탈퇴 </a>
	</div>
	
</body>
</html>