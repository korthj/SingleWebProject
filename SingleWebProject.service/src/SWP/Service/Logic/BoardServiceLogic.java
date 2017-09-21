package SWP.Service.Logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SWP.Dao.BoardDao;
import SWP.Service.BoardService;

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
