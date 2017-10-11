package SingleWebProject.Dao.Logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import SingleWebProject.Dao.PostingDao;
import SingleWebProject.Dao.Factory.SessionFactory;
import SingleWebProject.Dao.Mapper.PostingMapper;
import SingleWebProject.domain.Posting;

@Repository
public class PostingDaoLogic implements PostingDao {
	//
	@Override
	public List<Posting> allPageList(Map<String, Object> map) {
		// 전체 페이지를 읽어와서 페이징 함
		SqlSession session = SessionFactory.createInstance().getSession();
		PostingMapper mapper = session.getMapper(PostingMapper.class);
		
		List<Posting> list = mapper.allList(map);
		session.close();
			
		return list;
	}

}