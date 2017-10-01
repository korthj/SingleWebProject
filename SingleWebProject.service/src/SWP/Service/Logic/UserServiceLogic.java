package SWP.Service.Logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SWP.Dao.UserDao;
import SWP.Service.UserService;
import SWP.domain.User;

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
