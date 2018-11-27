package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import bean.Message;

public class MessageDao {
	private String account = "root";
	private String key ="Admit123";
	private String url = "jdbc:mysql://localhost:3306/we_blog?useSSL=false";

	public List<Message> getMessages(int userId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				String sql = "select * from messages where receiver_id='" + userId +"'";
				ResultSet rs = statement.executeQuery(sql);
				List<Message> messages = new ArrayList<Message>();
				while(rs.next()) {
					String date = rs.getString(1);
					String title = rs.getString(2);
					String context = rs.getString(3);
					int senderId = rs.getInt(4);
					int messageId = rs.getInt(6);
					Message message = new Message(date, title, context, senderId, userId, messageId);
					messages.add(message);
				}
				statement.close();
				connection.close();
				return messages;
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

	public int sendMessage(Message message) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				String sql = "insert into messages value(null,'"+ message.getTitle()+"','"+message.getContext()+"','"+message.getSenderId()+"','"+message.getReceiverId()+"',null)";
				int i = statement.executeUpdate(sql);
				statement.close();
				connection.close();
				return i;
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

	public void deleteMessage(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = (Connection) DriverManager.getConnection(url,account,key);
				Statement statement = connection.createStatement();
				String sql = "delete from messages where message_id='"+id+"'";
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
