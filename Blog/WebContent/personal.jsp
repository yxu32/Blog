<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>We-blog</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>

<div>
	<h1>We-blog</h1>
	
	<div class="connect">
		<p>Edit your personal information.</p>
	</div>
	
	<form action="UserInfo" method="post" id="personalInfoForm">
		<div>
			<input type="text" name="firstname" class="firstName" placeholder="Firs tname" autocomplete="off" value="${personalInfo.firstName }"/>
		</div>
		<div>
			<input type="text" name="lastname" class="LastName" placeholder="Last name" autocomplete="off" value="${personalInfo.lastName }"/>
		</div>
			
		<c:if test="${personalInfo.gender eq 'male' }">
		<div class="choose">
			<select name="gender">
  			<option value="male">male</option>
  			<option value="female">female</option>
			</select>
		</div>
		</c:if>
		
		<c:if test="${personalInfo.gender eq 'female'}">
		<div class="choose">
			<select name="gender">
  			<option value="female">female</option>
  			<option value="male">male</option>
			</select>
		</div>
		</c:if>
		
		<div>
			<input type="text" name="birthday" class="birthday" placeholder="Birthday YYYY-MM-DD or YYYY/MM/DD" autocomplete="off" value="${personalInfo.birthday }"/>
		</div>
		<div>
			<textarea type="text" name="briefIntro" class="briefIntro" placeholder="Brief Introduction" autocomplete="off">${personalInfo.briefIntro }</textarea>
		</div>
		<div>
			<textarea type="text" name="personalizedSignature" class="personalizedSignature" placeholder="Personalized Signature" autocomplete="off">${personalInfo.personalizedSignature }</textarea>
		</div>

		<button id="submit" type="submit">Confirm</button>
	</form>
</div>


<script src="js/jquery.min.js"></script>
<script src="js/common.js"></script>
<script src="js/jquery.validate.min.js?var1.14.0"></script>

</body>
</html>