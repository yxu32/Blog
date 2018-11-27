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
 * Servlet implementation class GetPersonalInfo
 */
@WebServlet("/GetPersonalInfo")
public class GetPersonalInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPersonalInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService userService = new UserService();
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("userId");
		PersonalInfo personalInfo = userService.getInfo(id);
		session.setAttribute("personalInfo", personalInfo);
		String url = (String) session.getAttribute("url");
		session.removeAttribute("url");
		if(url!=null) {
//			request.getRequestDispatcher(url).forward(request, response);
			response.sendRedirect(url);
		}else {
//			request.getRequestDispatcher("/personal.jsp").forward(request, response);
			response.sendRedirect("/Final/personal.jsp");
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
