package SWP.Service;

import java.util.List;

import SWP.domain.Board;


public interface BoardService {
	//
	public List<Board> allList(int count, int curPage, int start, int end);
	
	public int boardAllPageList(int boardId);
}
