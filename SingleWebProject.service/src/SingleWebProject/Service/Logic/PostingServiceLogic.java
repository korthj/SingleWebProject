package SingleWebProject.Service.Logic;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SingleWebProject.Dao.PostingDao;
import SingleWebProject.Service.PostingService;
import SingleWebProject.domain.Posting;

@Service
public class PostingServiceLogic implements PostingService{
	//
	@Autowired
	PostingDao postingDao;
	
	@Override
	public List<Posting> allList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return postingDao.allPageList(map);
	}

}
