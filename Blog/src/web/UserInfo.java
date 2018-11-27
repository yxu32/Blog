package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.PersonalInfo;
import service.UserService;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/UserInfo")
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String briefIntro = request.getParameter("briefIntro");
		String personalizedSignature = request.getParameter("personalizedSignature");
		birthday = birthday.replace("/", "-");
//		Cookie[] cookies = request.getCookies();
		int id = (int) session.getAttribute("userId");
		PersonalInfo personalInfo = new PersonalInfo(firstName, lastName, gender, birthday, briefIntro, personalizedSignature,id);
		UserService userService = new UserService();
		userService.setUserInfo(personalInfo);
//		for(Cookie cookie: cookies) {
//			String name = cookie.getName();
//			if(name.equals("userId")) {
//				int userId = Integer.parseInt(cookie.getValue());
//				PersonalInfo personalInfo = new PersonalInfo(firstName, lastName, gender, birthday, briefIntro, personalizedSignature,userId);
//				UserService userService = new UserService();
//				userService.setUserInfo(personalInfo);
//			}
//		}
		String url = "/Final/blog.jsp";
		session.setAttribute("url", url);
		request.getRequestDispatcher("/GetPersonalInfo").forward(request, response);
		
		
	}

}
