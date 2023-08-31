package com.springmvc.hotelReservation3;

import java.text.ParseException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.dto.MemberDTO;
import com.springmvc.hotelReservaion3.service.MemberService;
import com.springmvc.hotelReservation3.dto.ReservationDTO;

@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	//회원가입
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
	
	//로그인
	/*
	 * @GetMapping("/login") public String login(Model model) {
	 * model.addAttribute("loginForm", new MemberDTO()); return "/login";
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/login", method = RequestMethod.POST) public String
	 * login(@ModelAttribute("loginForm") MemberDTO memberdto, HttpSession session,
	 * Model model) throws Exception {
	 * 
	 * service.memberJoin(memberdto); model.addAttribute("dto", memberdto); return
	 * "redirect:/joinConfirm"; }
	 */
}
