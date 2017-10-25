package singleWebProject.service;

import java.util.List;
import java.util.Map;

import singleWebProject.domain.Posting;


public interface PostingService {

	List<Posting> allList(Map<String, Object> map);
	//
	
}
