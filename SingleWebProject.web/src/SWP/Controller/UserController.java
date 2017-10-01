package SWP.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import SWP.Service.UserService;
import SWP.domain.User;

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
			mav.addObject("message","error");
			mav.setViewName("/login.jsp");
			return mav;
		}else{
			session.setAttribute("user", users);
			mav.setViewName("/main.jsp");
			return mav;
		}
	} 
	
}
