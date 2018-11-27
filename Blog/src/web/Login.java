package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		UserService userService = new UserService();
		int ifManager = userService.getAuthority(username,password);
		if(ifManager==1) {
			request.getRequestDispatcher("/Manage").forward(request, response);
			System.out.println(ifManager);
		}else {
			int userId = userService.getId(username,password);
			session.setAttribute("userId", userId);
			session.setAttribute("personalInfo",null);
			session.setAttribute("singleBlogList",null);
			session.setAttribute("followList",null);
			session.setAttribute("followerList",null);
			session.setAttribute("followNameList",null);
			session.setAttribute("followerNameList",null);
			session.setAttribute("searchResult",null);
			session.setAttribute("messages", null);
			session.setAttribute("visitName", null);
			session.setAttribute("visitBlog", null);
			if(userId!=0) {
				Cookie cookie1 = new Cookie("JSESSIONID", session.getId());
				cookie1.setMaxAge(60*60);
				response.addCookie(cookie1);
				request.getRequestDispatcher("/GetBlog").forward(request, response);
			}else {
//				request.getRequestDispatcher("/loginError.html").forward(request, response);
				response.sendRedirect("/Final/loginError.html");
			}
		}
	}
	
	

}
