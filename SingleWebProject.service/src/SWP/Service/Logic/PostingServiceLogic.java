package SWP.Service.Logic;

import java.util.List;

import SWP.Dao.PostingDao;
import SWP.Service.PostingService;
import SWP.domain.Posting;

public class PostingServiceLogic implements PostingService{
	//
	PostingDao postingDao;
	@Override
	public List<Posting> allList(int start, int end, int boardId, int totalPageNo) {
		// TODO Auto-generated method stub
		return postingDao.allList(start,end,boardId,totalPageNo);
	}

}
