<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- Template at www.cssmoban.com -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>We_blog</title>
<link href="style1.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<table width="100%" align="center" class="table-corners">
  		<tr>
    		<td>
				<table border="0" align="center" cellpadding="0" cellspacing="0" class="main-table">
    				<tr>
    					<td colspan="2" class="top-img">
    					<br />
    					<br />
                		<span class="website-title">We_blog</span>
                		<br />
						</td>
      				</tr>
      				<tr>
        				<td colspan="2" class="menu">
        					<a class="menu-link" href="GetPersonalInfo">Edit information</a>
        					<a class="menu-link" href="GetBlog">Blog</a>
        					<a class="menu-link" href="GetFollows">Follows</a>
        					<a class="menu-link" href="GetFollowers">Followers</a>
        					<a class="menu-link" href="GetMessages">Message</a>
						</td>
					</tr>
					<tr>
      					<td class="content">
      						<button><a href="/Final/messages.jsp">back</a></button>
      						<form action="SendMessage" method = "post" id = "messageForm">
      							<div>
      								<!--  
      								<input type="text" name="to" class="to" placeholder="To" autocomplete="off"/>
      								-->
      								<select name="to" class="to">
      									<c:forEach items="${followNameList }" var = "follow">
      										<option value="${follow.id }">${follow.firstName }&nbsp${follow.lastName }</option>
      									</c:forEach>
      								</select>
      							</div>
      							<div>
      								<input type="text" name="title" class="title" placeholder="Title" autocomplete="off"/>
      							</div>
      							<div>
      								<textarea type="text" name="context" class="context" placeholder="Context" autocomplete="off"></textarea>
      							</div>
      							<br />
      							<button type="submit" id="submit">Send</button>
      						</form>
          				</td>
					</tr>
    				<tr>
       					<td colspan="2" align="right" class="footer">We_blog - <span class="made-in_text">
       					<!-- You can use this template for any purpose you want, but you have to leave this link -->
       					More Templates <a href="http://www.cssmoban.com/" target="_blank">http://www.cssmoban.com/</a></span>
       					</td>
    				</tr>
    			</table>
    		</td>
  		</tr>
	</table>
<script src="js/common.js"></script>
</body>
</html>