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
		// 
		return userDao.loginCheck(user);
	}

}
