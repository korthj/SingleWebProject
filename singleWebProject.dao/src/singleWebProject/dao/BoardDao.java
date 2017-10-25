package singleWebProject.dao;

import java.util.List;

import singleWebProject.domain.Board;

public interface BoardDao {

	List<Board> allList(int count, int curPage, int start, int end);

	int boardAllPageList(int boardId);

}
