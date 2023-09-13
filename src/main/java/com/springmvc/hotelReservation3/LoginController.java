package com.springmvc.hotelReservation3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.hotelReservaion3.service.MemberService;
import com.springmvc.hotelReservation3.dto.MemberDTO;

@Controller
@SessionAttributes({"id","idDetail"})
public class LoginController {
	
	@Autowired
	MemberService service;
	
	/* -----------------------로그인----------------------------*/
	 @GetMapping("/login") 
	 public String login(Model model) {
		model.addAttribute("loginForm", new MemberDTO()); 
		
		return "/login";  
	 }
	  
	  @RequestMapping(value = "/login", method = RequestMethod.POST) 
	  public String login(@ModelAttribute("loginForm") MemberDTO memberdto, HttpSession session, Model model) throws Exception {
		  MemberDTO Login = service.Login(memberdto);
		  
		  if(Login != null) { //로그인 성공
			 session.setAttribute("LoginDTO", Login);
			 String mID = Login.getM_id();
			 System.out.println("로그인 m_id: " + mID); 
			 model.addAttribute("m_id", mID); // 로그인 정보를 모델에 추가
			 return "/loginConfirm"; 
		  }else {
			  return "/loginAgain"; 
		  } 
	  }
	  
	  //로그인 틀렸을때
	  @GetMapping("/loginAgain") 
		 public String loginAgain(Model model) {
			model.addAttribute("loginForm", new MemberDTO());
			
			return "loginAgain";  
		 }
		  
	  @RequestMapping(value = "/loginAgain", method = RequestMethod.POST) 
	  public String loginAgain(@ModelAttribute("loginForm") MemberDTO memberdto, HttpSession session,HttpServletRequest request, Model model) throws Exception {
		  MemberDTO Login = service.Login(memberdto);
		  
			  if(Login != null) { //로그인 성공
				 session.setAttribute("LoginDTO", Login);
				 model.addAttribute("m_id", Login.getM_id()); // 로그인 정보를 모델에 추가
				 return "redirect:/loginConfirm"; 
			  } else {
				  return "loginAgain";  
			  }
	}
	  
	 //로그인 후 화면
	@GetMapping("/loginConfirm")
	public String requestLoginConfirmPage() {
			
		return"loginConfirm";
	}
	
	//로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET) 
	public String logout(HttpSession session){
	
		session.invalidate();
		return "redirect:/index";
		
	}
	
	 

}
