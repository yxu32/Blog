package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Message;
import service.MessageService;

/**
 * Servlet implementation class SendMessage
 */
@WebServlet("/SendMessage")
public class SendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessage() {
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
		MessageService messageService= new MessageService();
//		String to = request.getParameter("to");
		int to = Integer.parseInt(request.getParameter("to"));
		String title = request.getParameter("title");
		String context = request.getParameter("context");
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");
		
		
//		int receiverId = userService.getId(to);
//		Message message = new Message("",title,context,userId,receiverId,0);
		Message message = new Message("",title,context,userId,to,0);
		boolean success = messageService.sendMessage(message);
		if(success==true) {
			response.sendRedirect("/Final/messages.jsp");
		}else {
			response.sendRedirect("/Final/messages.jsp");
		}
		
	}

}
