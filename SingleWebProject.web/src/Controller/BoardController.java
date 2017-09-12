package Controller;

import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/Board")
public class BoardController {
	//
	@Autowired
	private BoardService boardService;
	
	//페이지 페이징 리스트
	@RequestMapping(value="/pageList.do", method = RequestMethod.GET)
	public ModelAndView pageList(@RequestParam int totalRecode,@RequestParam(defaultValue="1") int startPageNo, 
									ModelAndView mav, HttpSession session) throws Exception{
		//
		try{
		int totalPost = boardService.count(totalRecode);//보드에서 전체 게시물 받아옴
		Paging paging = new Paging(totalPost,startPageNo);
		paging
		paging.setPaging();

		return paging;
		}catch (Exception e1) {
			// TODO: handle exception
			System.out.println("BoardController(pageList):실행 중 오류 발생");
			e1.printStackTrace();
		}
	}
}
