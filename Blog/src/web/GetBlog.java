package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Blog;
import bean.Comment;
import bean.Name;
import bean.SingleBlog;
import service.BlogService;
import service.RelationService;
import service.UserService;

/**
 * Servlet implementation class Blog
 */
@WebServlet("/GetBlog")
public class GetBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBlog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		UserService userService = new UserService();
		BlogService blogService = new BlogService();
		RelationService relationService = new RelationService();
		
//		Cookie[] cookies = request.getCookies();
		int id = (int) session.getAttribute("userId");
		int[] follows =  relationService.getFollows(id);
		BlogService service = new BlogService();
		List<Blog> blogList = service.getBlog(id,follows);
		List<SingleBlog> singleBlogList = new ArrayList<SingleBlog>();
		
		for(Blog blog: blogList) {
			int blogId = blog.getBlogId();
			int publisherId = blog.getPublisherId();
			Name publisher = userService.getName(publisherId);
			List<Comment> comments= blogService.getComments(blogId);
			SingleBlog singleBlog = new SingleBlog(blog, publisher, comments);
			singleBlogList.add(singleBlog);
					
			session.setAttribute("singleBlogList", singleBlogList);
		}
		String blogId = (String) session.getAttribute("blogId");
		session.removeAttribute("blogId");
		if(blogId!=null) {
			response.sendRedirect("/Final/blog.jsp#"+blogId);
		}else {
			String url = "/Final/blog.jsp";
			session.setAttribute("url", url);
			request.getRequestDispatcher("/GetPersonalInfo").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
