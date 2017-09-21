package SWP.Dao.Mapper;

import java.util.List;
import java.util.Map;

import SWP.domain.Posting;

public interface PostingMapper {
	//
	List<Posting> allList(Map<String, Object> map);
}
