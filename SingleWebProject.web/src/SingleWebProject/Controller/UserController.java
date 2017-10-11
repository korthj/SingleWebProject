package SingleWebProject.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import SingleWebProject.Service.UserService;
import SingleWebProject.domain.User;

@Controller
@RequestMapping("/user")
public class UserController{
	//
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login.do")
	public ModelAndView loginCheck(User user,HttpSession session){
		ModelAndView mav = new ModelAndView();
		User users = userService.loginCheck(user);
		if(users != null){
			session.setAttribute("user", users);
			mav.setViewName("/index.jsp");
			return mav;
		}else{
			mav.addObject("message","error");
			mav.setViewName("/main/mainCover.jsp");
			return mav;
		}
	} 
	
}
