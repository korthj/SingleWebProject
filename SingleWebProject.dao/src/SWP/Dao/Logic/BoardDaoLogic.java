package SWP.Dao.Logic;

import java.util.List;

import SWP.Dao.BoardDao;
import SWP.domain.Board;

public class BoardDaoLogic implements BoardDao{

	@Override
	public List<Board> allList(int count, int curPage, int start, int end) {
		//전체 리스트를 리턴해주기 위한 로직
		return null;
	}

	@Override
	public int boardAllPageList(int boardId) {
		// boardId를 사용하여 게시판 구분하고 총 페이지 번호 수집
		
		return boardId;
	}
	//
	
}
