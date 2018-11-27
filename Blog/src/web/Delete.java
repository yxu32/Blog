package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BlogService;
import service.MessageService;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
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
		String deleteBlogId = request.getParameter("deleteBlogId");
		String deleteCommentId = request.getParameter("deleteCommentId");
		String deleteMessageId = request.getParameter("deleteMessageId");
		String manager = request.getParameter("manager");
		if(manager!=null) {
			if(deleteBlogId!=null) {
				BlogService blogService = new BlogService();
				blogService.deleteBlog(Integer.parseInt(deleteBlogId));
				request.getRequestDispatcher("/Manage").forward(request, response);
			}else if(deleteCommentId!=null){
				BlogService blogService = new BlogService();
				blogService.deleteComment(Integer.parseInt(deleteCommentId));
				request.getRequestDispatcher("/Manage").forward(request, response);
			}else {
				response.sendRedirect("/Final/manager.jsp");
			}
		}else {
			if(deleteBlogId!=null) {
				BlogService blogService = new BlogService();
				blogService.deleteBlog(Integer.parseInt(deleteBlogId));
				request.getRequestDispatcher("/GetBlog").forward(request, response);
			}else if(deleteCommentId!=null){
				BlogService blogService = new BlogService();
				blogService.deleteComment(Integer.parseInt(deleteCommentId));
				request.getRequestDispatcher("/GetBlog").forward(request, response);
			}else if(deleteMessageId!=null){
				MessageService messageService = new MessageService();
				messageService.deleteMessage(Integer.parseInt(deleteMessageId));
				request.getRequestDispatcher("/GetMessages").forward(request, response);
			}else {
				response.sendRedirect("/Final/follow.jsp");
			}
		}
		
	}

}
