package bean;

public class Blog {
	private int blogId;
	private String title;
	private String context;
	private int publisherId;
	
	public Blog(int blogId, String title, String context, int publisherId) {
		this.setBlogId(blogId);
		this.setTitle(title);
		this.setContext(context);
		this.setPublisherId(publisherId);
	}
	
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
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
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	
	
}
