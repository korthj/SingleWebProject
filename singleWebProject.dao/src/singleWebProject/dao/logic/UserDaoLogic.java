package singleWebProject.dao.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import singleWebProject.dao.UserDao;
import singleWebProject.dao.factory.SessionFactory;
import singleWebProject.dao.mapper.UserMapper;
import singleWebProject.domain.User;

@Repository
public class UserDaoLogic implements UserDao {
	//
	public User loginCheck(User user) {
		// 로그인 체크
		SqlSession session = SessionFactory.createInstance().getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		User users = mapper.loginCheck(user);
		session.close();
		return users;
	}

	@Override
	public String signUpIdCheck(User userId) {
		// 비동기 아이디 체크
		SqlSession session = SessionFactory.createInstance().getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		String users = mapper.signUpIdCheck(userId);
		session.close();
		return users;
	}

	@Override
	public void signUp(User user) {
		// 회원가입 
		SqlSession session = SessionFactory.createInstance().getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		mapper.signUp(user);
		session.close();
	}
}
