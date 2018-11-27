package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import bean.Blog;
import bean.Comment;
import bean.Name;
import util.SqlString;

public class BlogDao {
	private String account = "root";
	private String key ="Admit123";
	private String url = "jdbc:mysql://localhost:3306/we_blog?useSSL=false";
	
	public List<Blog> getBlog(int userId, int[] follows) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				String sql = "select * from blogs where publisher_id='" + userId +"'";
				for(int i: follows) {
					sql = sql+" or '"+i+"'" ;
				}
				sql = sql + " order by blog_id desc";
				ResultSet rs = statement.executeQuery(sql);
				List<Blog> blogList = new ArrayList<Blog>();
				while(rs.next()) {
					int blogId = rs.getInt(1);
					String title = rs.getString(2);
					String context = rs.getString(3);
					int publisherId = rs.getInt(4);
					Blog blog = new Blog(blogId, title, context, publisherId);
					blogList.add(blog);
				}
				statement.close();
				connection.close();
				return blogList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Blog> getBlog(int visitId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				String sql = "select * from blogs where publisher_id='" + visitId +"'  order by blog_id desc";
				ResultSet rs = statement.executeQuery(sql);
				List<Blog> blogList = new ArrayList<Blog>();
				while(rs.next()) {
					int blogId = rs.getInt(1);
					String title = rs.getString(2);
					String context = rs.getString(3);
					int publisherId = rs.getInt(4);
					Blog blog = new Blog(blogId, title, context, publisherId);
					blogList.add(blog);
				}
				statement.close();
				connection.close();
				return blogList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Comment> getComments(int blogId){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				String sql = "select * from comments where blog_id=('"+ blogId +"') order by comment_id asc";
				ResultSet rs = statement.executeQuery(sql);
				List<Comment> commentList = new ArrayList<Comment>();
				UserDao userDao = new UserDao();
				while(rs.next()) {
					int commentId = rs.getInt(1);
					String context = rs.getString(2);
					int reviewerId = rs.getInt(4);
					Name reviewer = userDao.getName(reviewerId);
					Comment comment = new Comment(commentId, context, blogId, reviewer);
					commentList.add(comment);
				}
				statement.close();
				connection.close();
				return commentList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void addComment(Comment comment) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				SqlString sqlString = new SqlString();
				String commentContext = sqlString.decode(comment.getContext());
				String sql = "insert into comments value ("+ null +",'"+ commentContext+ "','" + comment.getBlogId() + "','" + comment.getReviewerId()  +"')";
				statement.executeUpdate(sql);
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void post(Blog blog) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				String sql = "insert into blogs value ("+ null +",'"+ blog.getTitle()+ "','" + blog.getContext() + "','" + blog.getPublisherId()  +"')";
				statement.executeUpdate(sql);
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteBlog(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				String sql = "delete from blogs where blog_id='"+id+"'";
				statement.executeUpdate(sql);
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteComment(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				String sql = "delete from comments where comment_id='"+id+"'";
				statement.executeUpdate(sql);
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
