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
 * Servlet implementation class GetFollowers
 */
@WebServlet("/GetFollowers")
public class GetFollowers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFollowers() {
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
//		int[] followerList = relationService.getFollowers(userId);
//		List<Name> followerNameList = userService.getNameList(followerList);
//		session.setAttribute("followerList", followerList);
//		session.setAttribute("followerNameList", followerNameList);
//		response.sendRedirect("/Final/followers.jsp");
		
		int userId = (int) session.getAttribute("userId");
		int[] followerList = relationService.getFollowers(userId);
		List<Name> nameList = userService.getNameList(followerList);
		List<Name> followerNameList = relationService.check(userId,nameList);
		session.setAttribute("followerList", followerList);
		session.setAttribute("followerNameList", followerNameList);
		response.sendRedirect("/Final/followers.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
