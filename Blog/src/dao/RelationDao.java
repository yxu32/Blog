package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

public class RelationDao {
	private String account = "root";
	private String key ="Admit123";
	private String url = "jdbc:mysql://localhost:3306/we_blog?useSSL=false";
	
	
//	public String getFollows(int userId) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			try {
//				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
//				Statement statement = connection.createStatement();
//				String sql = "select follow_id from relationship where user_id ='"+ userId +"'";
//				ResultSet rs = statement.executeQuery(sql);
//				while(rs.next()) {
//					String follows = rs.getString(1);
//					statement.close();
//					connection.close();
//					return follows;
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	public List<Integer> getFollows(int userId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				String sql = "select follow from relation where follower ='"+ userId +"'";
				ResultSet rs = statement.executeQuery(sql);
				List<Integer> follows = new ArrayList<Integer>();
				while(rs.next()) {
					int id = rs.getInt(1);
					follows.add(id);
				}
				statement.close();
				connection.close();
				return follows;
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
	
//	public String getFollowers(int userId) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			try {
//				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
//				Statement statement = connection.createStatement();
//				String sql = "select follower_id from relationship where user_id ='"+ userId +"'";
//				ResultSet rs = statement.executeQuery(sql);
//				while(rs.next()) {
//					String followers = rs.getString(1);
//					statement.close();
//					connection.close();
//					return followers;
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	public List<Integer> getFollowers(int userId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				String sql = "select follower from relation where follow ='"+ userId +"'";
				ResultSet rs = statement.executeQuery(sql);
				List<Integer> followers = new ArrayList<Integer>();
				while(rs.next()) {
					int id = rs.getInt(1);
					followers.add(id);
				}
				statement.close();
				connection.close();
				return followers;
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
	
//	public void follow(String followList) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			try {
//				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
//				Statement statement = connection.createStatement();
//				String sql = "update relationship set follow_id='"+ followList +"'";
//				statement.executeQuery(sql);
//				statement.close();
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public void follow(int userId, String followId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				String sql = "insert into relation value('"+ userId +"','" + followId+"')";
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
	
//	public void followed(String followerList) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			try {
//				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
//				Statement statement = connection.createStatement();
//				String sql = "update relationship set follower_id='"+ followerList +"'";
//				statement.executeQuery(sql);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

//	public boolean checkFollow(int checkId, int userId) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			try {
//				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
//				Statement statement = connection.createStatement();
//				String sql = "select * from relationship where userId='" + userId +"' and follow_id ="+"";
//				statement.executeQuery(sql);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}

	public void unfollow(int userId, String unFollowId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				String sql = "delete from relation where follower='"+ userId +"' and follow='"+unFollowId+"'";
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

	public boolean followed(int userId, String followId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				String sql = "select * from relation where follower ='"+ userId +"' and follow='"+ followId +"'";
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next()) {
					statement.close();
					connection.close();
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
}
