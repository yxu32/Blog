package service;

import java.util.List;

import bean.Message;
import dao.MessageDao;
import dao.UserDao;

public class MessageService {
	public List<Message> getMessage(int userId){
		MessageDao messageDao = new MessageDao();
		UserDao userDao = new UserDao();
		List<Message> messages = messageDao.getMessages(userId);
		for(Message message: messages) {
			message.setName(userDao.getName(message.getSenderId()));
		}
		return messages;
	}

	public boolean sendMessage(Message message) {
		MessageDao messageDao = new MessageDao();
		int i = messageDao.sendMessage(message);
		if(i == 1) {
			return true;
		}else {
			return false;
		}
	}

	public void deleteMessage(int id) {
		MessageDao messageDao = new MessageDao();
		messageDao.deleteMessage(id);
	}
}
