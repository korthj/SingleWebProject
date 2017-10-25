package singleWebProject.dao;

import java.util.List;
import java.util.Map;

import singleWebProject.domain.Posting;

public interface PostingDao {
	//
	List<Posting> allPageList(Map<String, Object> map);

	
}
