package singleWebProject.dao.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import singleWebProject.dao.BoardDao;
import singleWebProject.dao.factory.SessionFactory;
import singleWebProject.dao.mapper.BoardMapper;
import singleWebProject.domain.Board;

@Repository
public class BoardDaoLogic implements BoardDao{
	//
	@Override
	public List<Board> allList(int count, int curPage, int start, int end) {
		//전체 리스트를 리턴해주기 위한 로직
		return null;
	}

	@Override
	public int boardAllPageList(int boardId) {
		// boardId를 사용하여 게시판 구분하고 총 페이지 번호 수집
		SqlSession session = SessionFactory.createInstance().getSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		int boardList = mapper.boardAllPageList(boardId);
		
		return boardList;
	}
	//
	
}
