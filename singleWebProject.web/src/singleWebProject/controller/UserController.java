package singleWebProject.controller;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	@Autowired
	private static String RSA_WEB_KEY = "_RSA_WEB_KEY_";//개인키 session key
	@Autowired
	private static String RSA_INSTANCE = "RSA";//rsa transformation
	
	@RequestMapping("/loginForm.do")
	public ModelAndView loginForm(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		//
		//rsa키 생성
		initRsa(req);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("/main/mainPage.do");
		
		return mav;
	}
	
	@RequestMapping("/login.do")
	@ResponseBody
	public ModelAndView loginCheck(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		//
		String userId = req.getParameter("USER_ID");
		String userPw = req.getParameter("USER_PW");
		
		HttpSession session = req.getSession();
		PrivateKey privateKey = (PrivateKey) session.getAttribute(UserController.RSA_WEB_KEY);

		//복호화
		userId = decryptRsa(privateKey, userId);
		userPw = decryptRsa(privateKey, userPw);
		//개인키삭제
		session.removeAttribute(UserController.RSA_WEB_KEY);
		
		ModelAndView mav = new ModelAndView();
		
		User user = new User();
		user.setUserId(userId);
		user.setUserPw(userPw);
	    user = userService.loginCheck(user);
		if(user != null){
			session.setAttribute("user", user);
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
	/**
     * 복호화
     * 
     * @param privateKey
     * @param securedValue
     * @return
     * @throws Exception
     */
    private String decryptRsa(PrivateKey privateKey, String securedValue) throws Exception {
        Cipher cipher = Cipher.getInstance(UserController.RSA_INSTANCE);
                
        byte[] encryptedBytes = hexToByteArray(securedValue);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedValue = new String(decryptedBytes, "utf-8"); // 문자 인코딩 주의.
        return decryptedValue;
    }
    /**
     * 16진 문자열을 byte 배열로 변환한다.
     * 
     * @param hex
     * @return
     */
    public static byte[] hexToByteArray(String hex) {
        if (hex == null || hex.length() % 2 != 0) { return new byte[] {}; }
 
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length(); i += 2) {
            byte value = (byte) Integer.parseInt(hex.substring(i, i + 2), 16);
            bytes[(int) Math.floor(i / 2)] = value;
        }
        return bytes;
    }
 
    /**
     * rsa 공개키, 개인키 생성
     * 
     * @param request
     */
    public void initRsa(HttpServletRequest req) {
        HttpSession session = req.getSession();
        KeyPairGenerator generator;
        SecureRandom random;
        try {
        	random = new SecureRandom();
            generator = KeyPairGenerator.getInstance(UserController.RSA_INSTANCE);
            generator.initialize(1024, random);
 
            KeyPair keyPair = generator.genKeyPair();
            KeyFactory keyFactory = KeyFactory.getInstance(UserController.RSA_INSTANCE);
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();
 
            session.setAttribute(UserController.RSA_WEB_KEY, privateKey); // session에 RSA 개인키를 세션에 저장
 
            RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
            String publicKeyModulus = publicSpec.getModulus().toString(16);
            String publicKeyExponent = publicSpec.getPublicExponent().toString(16);
 
            req.setAttribute("RSAModulus", publicKeyModulus); // rsa modulus 를 request 에 추가
            req.setAttribute("RSAExponent", publicKeyExponent); // rsa exponent 를 request 에 추가
        } catch (Exception e) {
            // TODO Auto-generated catch block
        	System.out.println("initRsa오류 발생");
            e.printStackTrace();
        }
    }
	
}
