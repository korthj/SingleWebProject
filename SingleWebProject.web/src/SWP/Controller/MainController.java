package SWP.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import SWP.domain.User;

@Controller
@RequestMapping("/main")
public class MainController {
	//
	@RequestMapping("/mainPage.do")
	public ModelAndView mainPage(HttpSession session){
		//인덱스에서 호출 받아서 유저 정보를 받아서 메인페이지에 유저정보를 받아서 뷰를 전달
		User user = (User) session.getAttribute("user");
		
		ModelAndView mav = new ModelAndView();
		
		if(user != null){
			mav.setViewName("/main/mainCover.jsp");
			mav.addObject(user);
			return mav;
		}	
		mav.setViewName("/main/mainCover.jsp");			
		return mav;
	}
}
