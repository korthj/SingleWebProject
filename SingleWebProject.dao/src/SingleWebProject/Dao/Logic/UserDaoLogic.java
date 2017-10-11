package SingleWebProject.Dao.Logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import SingleWebProject.Dao.UserDao;
import SingleWebProject.Dao.Factory.SessionFactory;
import SingleWebProject.Dao.Mapper.UserMapper;
import SingleWebProject.domain.User;

@Repository
public class UserDaoLogic implements UserDao {

	@Override
	public User loginCheck(User user) {
		// 로그인 체크
		SqlSession session = SessionFactory.createInstance().getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		User users = mapper.loginCheck(user);
		session.close();
		
		return users;
	}
}