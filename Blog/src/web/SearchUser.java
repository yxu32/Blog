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
import service.UserService;

/**
 * Servlet implementation class SearchUser
 */
@WebServlet("/SearchUser")
public class SearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUser() {
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
//		String search = request.getParameter("search");
//		HttpSession session = request.getSession();
//		int userId = (int) session.getAttribute("userId");
//		if(search!=null) {
//			UserService userService = new UserService();
//			List<Name> names = userService.searchFriend(search,userId);
//			RelationService relationService	 = new RelationService();
//			for(Name singleName: names ) {
//				Name checked = relationService.check(singleName,userId);
//			}
//		}else {
//			
//		}
		
		String search = request.getParameter("search");
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		if(search!=null) {
			UserService userService = new UserService();
			List<Name> names = userService.searchFriend(search,userId);
			session.setAttribute("searchResult", names);
			response.sendRedirect("/Final/searchFriend.jsp");
		}else {
			
		}
		
	}

}
