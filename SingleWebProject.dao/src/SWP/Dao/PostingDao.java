package SWP.Dao;

import java.util.List;

import SWP.domain.Posting;

public interface PostingDao {
	//
	List<Posting> allList(int start, int end, int boardId, int totalPageNo);

	
}
