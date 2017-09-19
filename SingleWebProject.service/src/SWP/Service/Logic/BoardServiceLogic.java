package SWP.Service.Logic;

import java.util.List;

import SWP.Dao.BoardDao;
import SWP.Service.BoardService;
import SWP.domain.Board;

public class BoardServiceLogic implements BoardService {
	//
	BoardDao boardDao;
	
	@Override
	public List<Board> allList(int count,int curPage,int start, int end){
		//
		return boardDao.allList(count,curPage,start,end);
	}

	@Override
	public int boardAllPageList(int boardId) {
		// TODO Auto-generated method stub		
		return boardDao.boardAllPageList(boardId);
	}
	
	
	
}
