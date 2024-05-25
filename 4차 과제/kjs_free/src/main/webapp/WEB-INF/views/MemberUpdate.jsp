<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Member Update</title>
	<link rel="stylesheet" href="resources/styles.css">
</head>
<body>
	
	<div class="container mt-5">
		<header class="text-center my-5">
			<h1 class="fw-bolder">Update Your Account</h1>
		</header>
		
		<div class="mx-6">
			<div class="card mb-4">
			<form class="m-5" action="http://localhost:8080/kangjinhyuk_free/MemberServlet?cmd=update" method="post">
				<fieldset>
					<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
						<li class="fw-bolder">ID<br><input class="form-control" type="text" name="id" readonly value="${ member.id }"></li><br>
						<li class="fw-bolder">PASSWORD<br><input class="form-control" type="password" name="passwd" autofocus required value="${ member.passwd }" ></li><br>
						<li class="fw-bolder">NICKNAME<br><input class="form-control" type="text" name="nickname" required value="${ member.nickname }"></li><br>
						<li class="fw-bolder">EMAIL<br><input class="form-control" type="text" name="email" value="${ member.email }"></li>
					</ul>
				</fieldset>
				<br><br>
				<fieldset class="text-center">
					<input class="btn btn-primary form-control" type="submit" name="submit" value="Update">
				</fieldset>
			</form>
			</div>
		</div>
	</div>
</body>
</html>