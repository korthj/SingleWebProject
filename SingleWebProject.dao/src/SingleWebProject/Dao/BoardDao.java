package SingleWebProject.Dao;

import java.util.List;

import SingleWebProject.domain.Board;

public interface BoardDao {

	List<Board> allList(int count, int curPage, int start, int end);

	int boardAllPageList(int boardId);

}
