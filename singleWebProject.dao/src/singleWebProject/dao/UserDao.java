package singleWebProject.dao;

import singleWebProject.domain.User;

public interface UserDao {

	User loginCheck(User user);
	
	String signUpIdCheck(User userId);
	
	void signUp(User user);
}
