package service;

import java.util.ArrayList;
import java.util.List;

import bean.Name;
import bean.PersonalInfo;
import bean.User;
import dao.RelationDao;
import dao.UserDao;
import util.SearchInput;

public class UserService {

	public boolean checkUser(String user_name) {
		UserDao userDao = new UserDao();
		return userDao.userCheck(user_name);
	}
	
	public void register(User user) {
		UserDao userDao = new UserDao();
		userDao.add(user);
	}
	
	public void setUserInfo(PersonalInfo personalInfo) {
		UserDao userDao = new UserDao();
		userDao.pudate(personalInfo);
	}

	public int getId(String username, String password) {
		UserDao userDao = new UserDao();
		return userDao.getId(username,password);
	}
	
	public Name getName(int userId) {
		UserDao userDao = new UserDao();
		return userDao.getName(userId);
	}
	
	public int getId(String name) {
		SearchInput si = new SearchInput();
		UserDao userDao = new UserDao();
		String[] getName = si.split(name);
		return userDao.getId(getName);
		
	}
	
	public PersonalInfo getInfo(int userId) {
		UserDao userDao = new UserDao();
		return userDao.getInfo(userId);
	}
	
	public List<Name> getNameList(int[] idList){
		UserDao userDao = new UserDao();
		List<Name> nameList= new ArrayList<Name>();
		for(int id: idList) {
			Name name = userDao.getName(id);
			nameList.add(name);
		}
		return nameList;
	}
	
	public List<Name> searchFriend(String search,int userId){
		SearchInput si = new SearchInput();
		UserDao userDao = new UserDao();
		RelationDao relationDao = new RelationDao();
		String[] condition = si.split(search);
		List<Name> names =  userDao.searchFriend(condition);
		for(Name name: names) {
			name.setFollow(relationDao.followed(userId, String.valueOf(name.getId())));
		}
		return names;
	}

	public int getAuthority(String username, String password) {
		UserDao userDao = new UserDao();
		return userDao.getAuthority(username,password);
	}

	public List<Name> userManage() {
		UserDao userDao = new UserDao();
		List<Integer> userIds =  userDao.userManage();
		List<Name> names = new ArrayList<Name>();
		for(Integer Id: userIds) {
			Name name = userDao.getName(Id);
			names.add(name);
		}
		return names;
	}
}
