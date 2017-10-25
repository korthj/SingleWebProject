package singleWebProject.dao.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import singleWebProject.dao.PostingDao;
import singleWebProject.dao.factory.SessionFactory;
import singleWebProject.dao.mapper.PostingMapper;
import singleWebProject.domain.Posting;

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
