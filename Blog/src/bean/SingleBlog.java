package bean;

import java.util.List;

public class SingleBlog {
	private Blog blog;
	private Name publisher;
	private List<Comment> comments;
	
	public SingleBlog(Blog blog, Name publisher, List<Comment> comments) {
		this.setBlog(blog);
		this.setPublisher(publisher);
		this.setComments(comments);
	}
	
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public Name getPublisher() {
		return publisher;
	}
	public void setPublisher(Name publisher) {
		this.publisher = publisher;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
