package SWP.Dao;

import java.util.List;
import java.util.Map;

import SWP.domain.Posting;

public interface PostingDao {
	//
	List<Posting> allPageList(Map<String, Object> map);

	
}
