package SingleWebProject.Dao;

import java.util.List;
import java.util.Map;

import SingleWebProject.domain.Posting;

public interface PostingDao {
	//
	List<Posting> allPageList(Map<String, Object> map);

	
}
