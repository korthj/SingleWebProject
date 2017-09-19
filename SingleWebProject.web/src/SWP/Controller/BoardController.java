package SWP.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SWP.Service.BoardService;
import SWP.Service.PostingService;
import SWP.domain.Board;
import SWP.domain.Paging;
import SWP.domain.Posting;
@Controller
@RequestMapping("/BoardPostList")
public class BoardController {
	//
	@Autowired
	private BoardService boardService;
	private PostingService postingService;
	
	//페이지 페이징 리스트
	@RequestMapping(value="/pageList.do", method = RequestMethod.GET)
	public ModelAndView pageList(@RequestParam(defaultValue="1") int curPage, 
									@RequestParam int boardId, ModelAndView mav, HttpSession session) throws Exception {
		//레코드의 갯수 설정
		int count = boardService.boardAllPageList(boardId);
	
		//페이징 관련 처리
		Paging paging = new Paging(count,curPage);
		int start = paging.getStartBlockPage();
		int end = paging.getEndBlockPage();
		int totalPageNo = paging.getTotalPage();
		
		List<Posting> list = postingService.allList(start, end, boardId, totalPageNo);
		
		//map을 이용하여 키와 밸류 저장
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("boardId", boardId);
		map.put("totalPageNo", totalPageNo);
		map.put("paging", paging);
		
		mav.addObject("map",map);
		mav.setViewName("board/list");
		
	return mav;
	}
}
