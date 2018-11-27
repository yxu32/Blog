<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	%>
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
						<td width="200" class="content-right">
        					<h1>Hello: ${personalInfo.firstName }&nbsp${personalInfo.lastName }</h1><br />
        					<p>Personized Signature:<br />&nbsp&nbsp${personalInfo.personalizedSignature }</p>
       					</td>
      					<td class="content">
      						<form action="PostBlog" method="post" id="blogForm">
      							<div>
      								<input type="text" name="title" class="title" placeholder="Title" autocomplete="off"/>
      							</div>
      							<div>
      							<textarea type="text" name="context" class="context" placeholder="Post your blog here.." autocomplete="off"></textarea>
      							</div>
      							<button type="submit" id="submit">Post</button>
      						</form>
      						<hr></hr>
      						<c:forEach items="${singleBlogList }" var="singleBlog">
      							
      							<a name="${singleBlog.blog.blogId }"></a>
      								<h1>Topic:${singleBlog.blog.title }</h1>
      								<p>Post by:<a href="/Final/Visit?visitId=${singleBlog.publisher.id}">${singleBlog.publisher.firstName } &nbsp${singleBlog.publisher.lastName }</a></p>
      								<p>
      								${singleBlog.blog.context }
      								</p>
      								<c:if test="${singleBlog.blog.publisherId eq userId }">
      									<form action="Delete" method="post">
      										<div class="hide">
      											<input type="text" name = "deleteBlogId" value="${singleBlog.blog.blogId }" />
      										</div>
      									<button id="submit" type="submit">Delete</button>
      									</form>
      								</c:if>
      								<form action="AddComment" method="post" id="commentForm">
      									<div class="hide">
      										<input type="text" name = "blogId" value="${singleBlog.blog.blogId }" />
      									</div>
      									<div>
											<input type="text" name="comment" class="comment" placeholder="Type your comment here.." autocomplete="off"/>
										</div>
										<button id="submit" type="submit">Comment</button>
									</form>
      								<p>Coments:</p>
      								<c:forEach items="${singleBlog.comments }" var="comment">
      									<p class="comments"><a href="/Final/Visit?visitId=${comment.reviewer.id}">${comment.reviewer.firstName }&nbsp${comment.reviewer.lastName }</a>:${comment.context }</p>
      									<c:if test="${comment.reviewer.id eq userId}">
      										<form action="Delete" method="post">
      											<div class="hide">
      												<input type="text" name = "deleteCommentId" value="${comment.commentId }" />
      											</div>
      										<button id="submit" type="submit">DeleteComment</button>
      										</form>
      									</c:if>
      								</c:forEach>
      						</c:forEach>
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