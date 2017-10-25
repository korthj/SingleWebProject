package singleWebProject.service.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import singleWebProject.dao.BoardDao;
import singleWebProject.service.BoardService;

@Service
public class BoardServiceLogic implements BoardService {
	//
	@Autowired
	private BoardDao boardDao;

	@Override
	public int boardAllPageList(int boardId) {
		// TODO Auto-generated method stub		
		return boardDao.boardAllPageList(boardId);
	}
	
	
	
}
