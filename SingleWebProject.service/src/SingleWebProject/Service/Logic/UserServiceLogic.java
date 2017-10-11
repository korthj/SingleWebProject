package SingleWebProject.Service.Logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SingleWebProject.Dao.UserDao;
import SingleWebProject.Service.UserService;
import SingleWebProject.domain.User;

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
