<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>We-blog</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="style.css" />
</head>
<body>

<div class="login-container">
	<h1>We-blog Login</h1>
	
	<div class="connect">
		<p>http://localhost:8080/Final/index.jsp</p>
	</div>
	
	<form action="Login" method="post" id="loginForm">
		<div>
			<input type="text" name="username" class="username" placeholder="Username" autocomplete="off"/>
		</div>
		<div>
			<input type="password" name="password" class="password" placeholder="Password" oncontextmenu="return false" onpaste="return false" />
		</div>
		<button id="submit" type="submit">Login</button>
	</form>

	<a href="register.jsp">
		<button type="button" class="register-tis">Create new account</button>
	</a>

</div>

<script src="js/jquery.min.js"></script>
<script src="js/common.js"></script>
<script src="js/jquery.validate.min.js?var1.14.0"></script>

</body>
</html>