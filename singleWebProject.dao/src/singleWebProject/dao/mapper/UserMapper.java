package singleWebProject.dao.mapper;

import singleWebProject.domain.User;

public interface UserMapper {
	//
	User loginCheck(User user);
	
	String signUpIdCheck(User userId);
	
	void signUp(User user);
}
