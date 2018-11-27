package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Name;
import bean.SingleBlog;
import service.BlogService;
import service.UserService;

/**
 * Servlet implementation class ManageBlog
 */
@WebServlet("/ManageBlog")
public class ManageBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageBlog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String manageId = request.getParameter("manageId");
		HttpSession session = request.getSession();
		UserService userService = new UserService();
		BlogService blogService = new BlogService();
		
		Name name = userService.getName(Integer.parseInt(manageId));
		List<SingleBlog> manageBlogs =  blogService.getBlog(Integer.parseInt(manageId));
		session.setAttribute("manageName", name);
		session.setAttribute("manageBlog", manageBlogs);
		response.sendRedirect("/Final/manageBlog.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
