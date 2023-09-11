package com.springmvc.hotelReservation3;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.hotelReservaion3.service.MemberService;
import com.springmvc.hotelReservation3.dto.MemberDTO;
import com.springmvc.hotelReservation3.dto.ReservationDTO;

@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
/* -------------------------회원가입----------------------------*/
	@GetMapping("/join")
	public String Join(Model model) {
		model.addAttribute("joinForm", new MemberDTO());
		return "/join";
		
	}
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String Join(@ModelAttribute("joinForm") MemberDTO memberdto, HttpSession session,
	Model model) throws Exception {
		
		service.memberJoin(memberdto);
		model.addAttribute("dto", memberdto);
		return "redirect:/joinConfirm";	
	}
	
	@GetMapping("/joinConfirm")
	public String requestJoinConfirmPage() {
		
		return"joinConfirm";
	}
	
	//아이디 중복체크
	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPost(@RequestParam("memberId") String memberId) throws Exception {
	    int result = service.idCheck(memberId);
	    if (result != 0) {
	        return "fail"; // 중복아이디 존재
	    } else {
	        return "success";
	    }
	}
} 

	  

