package singleWebProject.service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import singleWebProject.dao.UserDao;
import singleWebProject.domain.User;
import singleWebProject.service.UserService;

@Service
public class UserServiceLogic implements UserService {
	//
	@Autowired
	private UserDao userDao;

	@Override
	public User loginCheck(User user) {
		// TODO Auto-generated method stub
		return userDao.loginCheck(user);
	}

	@Override
	public String signUpIdCheck(User userId) {
		// TODO Auto-generated method stub
		return userDao.signUpIdCheck(userId);
	}

	@Override
	public void signUp(User user) {
		// TODO Auto-generated method stub
		userDao.signUp(user);
	}
	
	

}
