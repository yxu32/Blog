package bean;

public class Comment {
	private int commentId;
	private String context;
	private int blogId;
	private int reviewerId;
	private Name reviewer;
	
	public Comment(int blogId, String context,int reviewerId) {
		this.setBlogId(blogId);
		this.setContext(context);
		this.setReviewerId(reviewerId);
	}
	
	public Comment(int commentId, String context, int blogId, Name reviewer) {
		this.setCommentId(commentId);
		this.setContext(context);
		this.setBlogId(blogId);
		this.setReviewer(reviewer);
	}
	
	public Name getReviewer() {
		return reviewer;
	}

	public void setReviewer(Name reviewer) {
		this.reviewer = reviewer;
	}

	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public int getReviewerId() {
		return reviewerId;
	}
	public void setReviewerId(int reviewerId) {
		this.reviewerId = reviewerId;
	}
}
