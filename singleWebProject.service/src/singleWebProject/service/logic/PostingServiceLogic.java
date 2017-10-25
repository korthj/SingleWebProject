package singleWebProject.service.logic;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import singleWebProject.dao.PostingDao;
import singleWebProject.domain.Posting;
import singleWebProject.service.PostingService;

@Service
public class PostingServiceLogic implements PostingService{
	//
	@Autowired
	private PostingDao postingDao;
	
	@Override
	public List<Posting> allList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return postingDao.allPageList(map);
	}

}
