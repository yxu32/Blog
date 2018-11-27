package bean;

public class Name {
	private String firstName;
	private String lastName;
	private int id;
	private boolean follow= false;
	private boolean follower = false;
	
	public Name(String firstName, String lastName,int id,boolean follow, boolean follower) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setId(id);
		this.setFollow(follower);
		this.setFollower(follower);
	}
	
	public Name(String firstName, String lastName,int id) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setId(id);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isFollow() {
		return follow;
	}

	public void setFollow(boolean follow) {
		this.follow = follow;
	}

	public boolean isFollower() {
		return follower;
	}

	public void setFollower(boolean follower) {
		this.follower = follower;
	}
	
}
