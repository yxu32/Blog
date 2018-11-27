package service;
import java.util.ArrayList;
import java.util.List;

import bean.Blog;
import bean.Comment;
import bean.SingleBlog;
import dao.BlogDao;

public class BlogService {

	public List<Blog> getBlog(int userId, int[] follows){
		BlogDao blogDao = new BlogDao();
		return blogDao.getBlog(userId,follows);
		
	}
	
	public List<Comment> getComments(int blogId){
		BlogDao blogDao = new BlogDao();
		return blogDao.getComments(blogId);
	}
	
	public void addComment(Comment comment) {
		BlogDao blogDao = new BlogDao();
		blogDao.addComment(comment);
	}

	public void post(Blog blog) {
		BlogDao blogDao = new BlogDao();
		blogDao.post(blog);
		
	}
	
	public List<SingleBlog> getBlog(int visitId){
		BlogDao blogDao = new BlogDao();
		List<SingleBlog> singleBlogs = new ArrayList<SingleBlog>();
		for(Blog blog: blogDao.getBlog(visitId)) {
			List<Comment> comments = new ArrayList<Comment>();
			comments = this.getComments(blog.getBlogId());
			SingleBlog singleBlog = new SingleBlog(blog, null, comments);
			singleBlogs.add(singleBlog);
		}
		return singleBlogs;
	}

	public void deleteBlog(int id) {
		BlogDao blogDao = new BlogDao();
		blogDao.deleteBlog(id);
	}

	public void deleteComment(int id) {
		BlogDao blogDao = new BlogDao();
		blogDao.deleteComment(id);
	}
}
