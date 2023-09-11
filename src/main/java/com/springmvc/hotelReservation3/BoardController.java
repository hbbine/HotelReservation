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

import com.springmvc.hotelReservaion3.service.BoardService;
import com.springmvc.hotelReservation3.dto.BoardDTO;
import com.springmvc.hotelReservation3.dto.MemberDTO;

@Controller
public class BoardController {

	@Autowired
	BoardService service;
	
	/* -------------------------글쓰기----------------------------*/
	@GetMapping("/writeBoard")
	public String insertBoard(Model model) {
		model.addAttribute("boardForm", new BoardDTO());
		return "/writeBoard";
	}
	
	@RequestMapping(value = "/writeBoard", method = RequestMethod.POST)
	public String insertBoard(@ModelAttribute("boardForm") BoardDTO boarddto,MemberDTO memberdto, HttpSession session,
		HttpServletRequest request,	Model model) throws Exception {
		
		service.insertBoard(boarddto);
		model.addAttribute("dto", boarddto);
		
		
		return "redirect:/boardOneview";	
	}
	
	@GetMapping("/boardOneview")
	public String boardOneview(Model model) {
		model.addAttribute("boardForm", new BoardDTO());
		return "/boardOneview";
	}
	
	
	
	
	
	
	
}
