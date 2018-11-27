package service;

import java.util.List;

import bean.Name;
import dao.RelationDao;

public class RelationService {
//	public int[] getFollows(int userId) {
//		RelationDao relationDao =new RelationDao();
//		String follows = relationDao.getFollows(userId);
//		if(follows!=null) {
//			String[] followArray = follows.split(",");
//			int[] followIntArray = new int[followArray.length];
//			int i = 0;
//			for(String str: followArray) {
//				followIntArray[i] = Integer.parseInt(str);
//				i+=1;
//			}
//			return followIntArray;
//		}else {
//			return null;
//		}
//	}
	
	public int[] getFollows(int userId) {
		RelationDao relationDao =new RelationDao();
		Object[] result = relationDao.getFollows(userId).toArray();
		int[] follows = new int[result.length];
		int i = 0;
		for(Object obj: result) {
			follows[i]= (int) obj;
			i+=1;
		}
		return follows;
	}
	
//	public int[] getFollowers(int userId) {
//		RelationDao relationDao =new RelationDao();
//		String followers = relationDao.getFollowers(userId);
//		if(followers!=null) {
//			String[] followerArray = followers.split(",");
//			int[] followerIntArray = new int[followerArray.length];
//			int i = 0;
//			for(String str: followerArray) {
//				followerIntArray[i] = Integer.parseInt(str);
//				i+=1;
//			}
//			return followerIntArray;
//		}else {
//			return null;
//		}
//	}
	
	public int[] getFollowers(int userId) {
		RelationDao relationDao =new RelationDao();
		Object[] result = relationDao.getFollowers(userId).toArray();
		int[] followers = new int[result.length];
		int i = 0;
		for(Object obj: result) {
			followers[i]= (int) obj;
			i+=1;
		}
		return followers;
	}

	
//	public void follow(int userId, String followId) {
//		RelationDao relationDao =new RelationDao();
//		String followList = relationDao.getFollows(userId);
//		followList = followList+","+followId;
//		relationDao.follow(followList);
//		String followerList = relationDao.getFollowers(Integer.parseInt(followId));
//		followerList = followerList + "," + userId;
//		relationDao.followed(followerList);
//	}
	
	public void follow(int userId, String followId) {
		RelationDao relationDao =new RelationDao();
		if(!followed(userId, followId)) {
			relationDao.follow(userId, followId);
		}
	}

	public void unFollow(int userId, String unFollowId) {
		RelationDao relationDao =new RelationDao();
		relationDao.unfollow(userId, unFollowId);
	}
	
	public boolean followed(int userId, String followId) {
		RelationDao relationDao =new RelationDao();
		return relationDao.followed(userId, followId);
	}

	public List<Name> check(int userId, List<Name> nameList) {
		RelationDao relationDao =new RelationDao();
		for(Name name: nameList) {
			name.setFollow(relationDao.followed(userId, String.valueOf(name.getId())));
		}
		return nameList;
	}
	
//	public void unFollow(int userId, String unFollowId) {
//		RelationDao relationDao =new RelationDao();
//		DeleteId dele = new DeleteId();
//		String followList = relationDao.getFollows(userId);
//		String followerList = relationDao.getFollowers(Integer.parseInt(unFollowId));
//		String[] follow = followList.split(",");
//		String[] follower = followerList.split(",");
//		String id = String.valueOf(userId);
//		String newFollowList = dele.delete(follow, unFollowId);
//		String newFollowerList = dele.delete(follower, id);
//		relationDao.follow(newFollowList);
//		relationDao.followed(newFollowerList);
//		
//	}

//	public Name check(Name singleName, int userId) {
//		RelationDao relationDao =new RelationDao();
//		int checkId = singleName.getId();
//		if(relationDao.checkFollow(checkId,userId)) {
//			
//		}
//		if(relationDao.checkFollower(checkId,userId)) {
//			
//		}
//		return null;
//	}
}
