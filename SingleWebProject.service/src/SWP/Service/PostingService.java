package SWP.Service;

import java.util.List;

import SWP.domain.Posting;


public interface PostingService {

	List<Posting> allList(int start, int end, int boardId, int totalPageNo);
	//
	
}
