package bean;

public class Message {
	private String date;
	private String title;
	private String context;
	private int senderId;
	private Name name;
	private int receiverId;
	private int messageId;
	
	public Message(String date, String title, String context, int senderId, int receiverId, int messageId) {
		this.setDate(date);
		this.setTitle(title);
		this.setContext(context);
		this.setSenderId(senderId);
		this.setReceiverId(receiverId);
		this.setMessageId(messageId);
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
	
}
