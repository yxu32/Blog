<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>We-blog Register</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="style.css" />
</head>
<body>

<div class="register-container">
	<h1>We-blog</h1>
	
	<div class="connect">
		<p>Link the world. Share to world.</p>
	</div>
	
	<form action="register" method="post" id="registerForm">
		<div>
			<input type="text" name="username" class="username" placeholder="Your Userame" autocomplete="off"/>
		</div>
		<div>
			<input type="password" name="password" class="password" placeholder="Enter Password" />
		</div>
		<div>
			<input type="password" name="confirm_password" class="confirm_password" placeholder="Enter Password Again" />
		</div>
		<div>
			<input type="email" name="email" class="email" placeholder="E-mail Address" oncontextmenu="return false" onpaste="return false" />
		</div>

		<button id="submit" type="submit">Register</button>
	</form>
	<a href="index.jsp">
		<button type="button" class="register-tis">Login With Your Account</button>
	</a>

</div>
<script src="js/jquery.min.js"></script>
<script src="js/common.js"></script>
<script src="js/jquery.validate.min.js?var1.14.0"></script>

</body>
</html>