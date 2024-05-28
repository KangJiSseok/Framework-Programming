 <!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="../resources/styles.css">
</head>
<body>
	<div class="container mt-5">
		<header class="text-center my-5">
			<h1 class="fw-bolder">Blog Login</h1>
		</header>
		
		<div class="mx-6">
			<div class="card mb-4">
			<form class="m-5" action="/member/login" method="post">
				<fieldset>
					<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
						<li><input class="form-control" type="text" name="id" autofocus required placeholder="ID"></li>
						<li><input class="form-control" type="password" name="passwd" required placeholder="PASSWORD"></li>
					</ul>
				</fieldset>
				<br>
				<fieldset class="text-center">
					<input class="btn btn-primary form-control" type="submit" name="submit" value="Log in">
				</fieldset>
			</form>
			</div>
		</div>
	</div>
</body>
</html>