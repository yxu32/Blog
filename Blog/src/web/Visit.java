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
 * Servlet implementation class Visit
 */
@WebServlet("/Visit")
public class Visit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Visit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String visitId = request.getParameter("visitId");
		UserService userService = new UserService();
		BlogService blogService = new BlogService();
		
		Name name = userService.getName(Integer.parseInt(visitId));
		List<SingleBlog> visitBlogs =  blogService.getBlog(Integer.parseInt(visitId));
		session.setAttribute("visitName", name);
		session.setAttribute("visitBlog", visitBlogs);
		response.sendRedirect("/Final/visit.jsp");
		
	}

}
