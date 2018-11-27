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
import service.RelationService;
import service.UserService;

/**
 * Servlet implementation class GetFollows
 */
@WebServlet("/GetFollows")
public class GetFollows extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFollows() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RelationService relationService = new RelationService();
		UserService userService = new UserService();
		HttpSession session = request.getSession();
		
//		int userId = (int) session.getAttribute("userId");
//		int[] followList = relationService.getFollows(userId);
//		List<Name> followNameList = userService.getNameList(followList);
//		session.setAttribute("followList", followList);
//		session.setAttribute("followNameList", followNameList);
//		response.sendRedirect("/Final/follows.jsp");
		
		int userId = (int) session.getAttribute("userId");
		int[] followList = relationService.getFollows(userId);
		List<Name> followNameList = userService.getNameList(followList);
		session.setAttribute("followList", followList);
		session.setAttribute("followNameList", followNameList);
		String send = request.getParameter("send");
		if(send==null) {
			response.sendRedirect("/Final/follows.jsp");
		}else {
			response.sendRedirect("/Final/sendMessage.jsp");
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
