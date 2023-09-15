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
import com.springmvc.hotelReservation3.dto.BoardDTO;
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
	
/* -------------------------My information 수정----------------------------*/
	
	@GetMapping("/myInformation")
	public String updateBoard(Model model, HttpServletRequest request ) { //requestParam을 이용해서 url에 있는 id 값을 받아줌
		// 지금 로그인된 세션 정보
	    MemberDTO memberdto = (MemberDTO) request.getSession().getAttribute("LoginDTO"); //get now session info for convey joinform
		model.addAttribute("joinForm", memberdto ); //담은 memberdto를 joinForm 폼으로 보내주면 이전에 썼던 글이 생성되어있음
		
		return"myInformation";
	}
	
	@RequestMapping(value = "/myInformation", method = RequestMethod.POST)//수정 완료후 저장ㄴ
	public String updateBoard(@ModelAttribute("joinForm") MemberDTO memberdto, Model model) throws Exception { 
		
		service.updateMyInformation(memberdto);
		model.addAttribute("board",memberdto);
		
		String m_id = memberdto.getM_id();
	
	    return "/index";
	}
	
/* -------------------------Delete member----------------------------*/

	@GetMapping(value = "/deleteMember")
	public String deleteMember(Model model, @RequestParam("m_id") String m_id, HttpServletRequest request) throws Exception {

	    System.out.println("멤버 삭제 전 alertScript 실행 ID = " + m_id);

	    return "redirect:/deleteConfirm?m_id=" + m_id; //여기서 confirm으로 m_id랑 같이 보내줘야 confirm이 작동했음
	}
	
	@GetMapping(value = "/deleteConfirm")
	public String deleteConfirm(@RequestParam("m_id") String m_id, HttpSession session) throws Exception{
		
		service.deleteMember(m_id);
		session.invalidate();
		System.out.println("멤버 삭제" + m_id + "님");
		
		return "redirect:/index";
		
	}
	
	
	
} 

	  

