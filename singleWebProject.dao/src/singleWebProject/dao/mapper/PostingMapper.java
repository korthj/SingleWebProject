package singleWebProject.dao.mapper;

import java.util.List;
import java.util.Map;

import singleWebProject.domain.Posting;

public interface PostingMapper {
	//
	List<Posting> allList(Map<String, Object> map);
}
