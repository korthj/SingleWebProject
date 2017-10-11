package SingleWebProject.Service.Logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SingleWebProject.Dao.BoardDao;
import SingleWebProject.Service.BoardService;

@Service
public class BoardServiceLogic implements BoardService {
	//
	@Autowired
	BoardDao boardDao;

	@Override
	public int boardAllPageList(int boardId) {
		// TODO Auto-generated method stub		
		return boardDao.boardAllPageList(boardId);
	}
	
	
	
}
