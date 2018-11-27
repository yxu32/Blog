package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import bean.Name;
import bean.PersonalInfo;
import bean.User;
import util.SqlString;

public class UserDao {
	private String account = "root";
	private String key ="Admit123";
	private String url = "jdbc:mysql://localhost:3306/we_blog?useSSL=false";
	
	public boolean userCheck(String user_name){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				SqlString sqlString = new SqlString();
				String name = sqlString.decode(user_name);
				String sql = "select user_name from account_info where user_name= ('"+ name +"')";
				ResultSet result = statement.executeQuery(sql);
				if(result.next()) {
					statement.close();
					connection.close();
					return false;
				}else{
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

	public void add(User user) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				SqlString sqlString = new SqlString();
				String userName = sqlString.decode(user.getUsername());
				String password = sqlString.decode(user.getPassword());
				String email = sqlString.decode(user.getEmail());
				String sql = "insert into account_info VALUES ("+ "null" + ",'" + userName + "','" + password + "','" + email +"','"+ 0 + "')";
				statement.executeUpdate(sql);
				String sql_0 = "select user_id from account_info where user_name='"+ user.getUsername() +"'";
				ResultSet rs = statement.executeQuery(sql_0);
				while(rs.next()) {
					int user_id = rs.getInt(1);
					String sql_1 = "insert into user_info VALUES (" + "null" + "," + "null" + ",'" + "male" + "'," + "null" + "," + "null" + "," + "null" + ",'" + user_id + "')";
					statement.executeUpdate(sql_1);
					break;
				}
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

	public void pudate(PersonalInfo personalInfo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				SqlString sqlString = new SqlString();
				String firstName = sqlString.decode(personalInfo.getFirstName());
				String lastName = sqlString.decode(personalInfo.getLastName());
				String briefIntro = sqlString.decode(personalInfo.getBriefIntro());
				String personalizedSignature = sqlString.decode(personalInfo.getPersonalizedSignature());
				if(personalInfo.getBirthday()=="") {
					String sql ="update user_info set first_name='"+ firstName +"',last_name='"+lastName+"',Gender='"+ personalInfo.getGender() +"',self_intro='"+briefIntro +"',personalized_signature='"+personalizedSignature+"' where user_id='"+personalInfo.getUserId()+"'";
					statement.executeUpdate(sql);
				}else {
					String sql ="update user_info set first_name='"+ firstName +"',last_name='"+ lastName+"',Gender='"+personalInfo.getGender()+"',Birthday='"+personalInfo.getBirthday()+"',self_intro='"+ briefIntro +"',personalized_signature='"+ personalizedSignature+"' where user_id='"+personalInfo.getUserId()+"'";
					statement.executeUpdate(sql);
				}
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

	public int getId(String username, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				String sql = "select user_id from account_info where user_name='"+ username + "' "+ "and password='"+ password +"'";
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next()) {
					int userId = rs.getInt(1);
					statement.close();
					connection.close();
					return userId;
				}
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
		return 0;
		
	}
	
	public int getId(String[] str) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				String sql = "select user_id from user_info where first_name='"+ str[0] + "' "+ "and last_name='"+ str[1] +"'";
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next()) {
					int userId = rs.getInt(1);
					statement.close();
					connection.close();
					return userId;
				}
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
		return 0;
	}
	
	public Name getName(int userId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				String sql = "select first_name, last_name, user_id from user_info where user_id="+ userId +"";
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next()) {
					String firstName = rs.getString(1);
					String lastName = rs.getString(2);
					int id = rs.getInt(3);
					Name name = new Name(firstName,lastName,id);
					statement.close();
					connection.close();
					return name;
				}
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
	
	public PersonalInfo getInfo(int userId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				String sql = "select * from user_info where user_id="+ userId +"";
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next()) {
					String firstName = rs.getString(1);
					String lastName = rs.getString(2);
					String gender = rs.getString(3);
					String birthday = rs.getString(4);
					String briefIntro =rs.getString(5);
					String personalizedSignature = rs.getString(6);
					PersonalInfo personInfo = new PersonalInfo(firstName, lastName, gender, birthday, briefIntro, personalizedSignature, userId);
					statement.close();
					connection.close();
					return personInfo;
				}
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

	public List<Name> searchFriend(String[] condition) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				String sql = "";
				if(condition[1]==null) {
					sql = "select first_name, last_name, user_id from user_info where first_name like '%" + condition[0] + "%' or last_name like '%" + condition[0] + "%' limit 10";
				}else {
					sql = "select first_name, last_name, user_id from user_info where first_name like '%" + condition[0] + "%' or last_name like '%" + condition[0] + "%' or first_name like '%" + condition[1] + "%' or last_name like '%" + condition[1] + "%' limit 10";
				}
				ResultSet rs = statement.executeQuery(sql);
				List<Name> nameList = new ArrayList<Name>();
				while(rs.next()) {
					String firstName = rs.getString(1);
					String lastName = rs.getString(2);
					int id = rs.getInt(3);
					Name name = new Name(firstName, lastName, id);
					nameList.add(name);
				}
				statement.close();
				connection.close();
				return nameList;
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

	public int getAuthority(String username, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				String sql = "select manager from account_info where user_name='"+ username + "' "+ "and password='"+ password +"'";
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next()) {
					int manager = rs.getInt(1);
					statement.close();
					connection.close();
					return manager;
				}
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
		return 0;
		
	}

	public List<Integer> userManage() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				String sql = "select user_id from account_info where manager='"+ 0 +"'";
				ResultSet rs = statement.executeQuery(sql);
				List<Integer> userIds = new ArrayList<Integer>();
				while(rs.next()) {
					int userId = rs.getInt(1);
					userIds.add(userId);
				}
				statement.close();
				connection.close();
				return userIds;
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
}
