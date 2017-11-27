package singleWebProject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import singleWebProject.domain.User;
import singleWebProject.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController{
	//
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public ModelAndView loginCheck(HttpSession session,User user){
		ModelAndView mav = new ModelAndView();
		//User user = new User();
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
	
	@RequestMapping("/logout.do")
	@ResponseBody
	public ModelAndView logoutCheck(HttpSession session){
		//로그아
		ModelAndView mav = new ModelAndView();
		
		session.invalidate();
		mav.setViewName("/index.jsp");
		return mav;
	}
	
}
