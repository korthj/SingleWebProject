package SWP.Dao;

import java.util.List;

import SWP.domain.Board;

public interface BoardDao {

	List<Board> allList(int count, int curPage, int start, int end);

	int boardAllPageList(int boardId);

}
