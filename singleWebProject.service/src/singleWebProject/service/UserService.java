package singleWebProject.service;

import singleWebProject.domain.User;

public interface UserService {
	//
	User loginCheck(User user);
	
	String signUpIdCheck(User userId);
	
	void signUp(User user);
}
