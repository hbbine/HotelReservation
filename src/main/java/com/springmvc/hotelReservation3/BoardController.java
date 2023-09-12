package com.springmvc.hotelReservation3;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.hotelReservaion3.service.BoardService;
import com.springmvc.hotelReservation3.dto.BoardDTO;
import com.springmvc.hotelReservation3.dto.MemberDTO;
import com.springmvc.hotelReservation3.dto.ReservationDTO;

@Controller
public class BoardController {

	@Autowired
	BoardService service;
	
/* -------------------------글쓰기----------------------------*/
	
	@GetMapping("/writeBoard") //화면 불러오기전 가져올 값들
	public String insertBoard(Model model, BoardDTO boarddto, HttpServletRequest request ) {
		model.addAttribute("boardForm", new BoardDTO());
		MemberDTO memberdto = (MemberDTO) request.getSession().getAttribute("LoginDTO");
		
	    if (memberdto != null) {
	        // 로그인된 상태이므로 예약 페이지를 표시
	        model.addAttribute("m_id", memberdto.getM_id());
	        model.addAttribute("m_password", memberdto.getM_password());
	        
	        System.out.println("게시판 글쓰기 아이디값 확인: " + memberdto.getM_id());
	        System.out.println("게시판 글쓰기 비번값 확인: " + memberdto.getM_password());
	       
	        return "writeBoard";
	    } else {
	    	
	        // 로그인되지 않은 상태이므로 로그인 페이지로 이동
	        return "redirect:/login";
	    }
	}
	
	@RequestMapping(value = "/writeBoard", method = RequestMethod.POST) //화면 불러오고 나서 다시 입력할 값들
	public String insertBoard(@ModelAttribute("boardForm") BoardDTO boarddto,MemberDTO memberdto, HttpSession session,
		HttpServletRequest request,	Model model) throws Exception {
		
		service.insertBoard(boarddto);
		model.addAttribute("dto", boarddto);
		
		return "redirect:/boardList";	
	}

/* -------------------------목록----------------------------*/
	
	@GetMapping("/boardList")
	public String boardList(Model model) {
		List<BoardDTO> getallboardList = service.getAllBoardList();
		model.addAttribute("boardList", getallboardList);
		return "/boardList";
	}
	
/* -------------------------원글 보기----------------------------*/
	
	@GetMapping("/boardOneview") //화면 불러오기전 가져올 값들
	public String boardOneview(Model model, @RequestParam("b_id") int b_id ) {
		
		//게시글 정보 가져오기
		BoardDTO boarddto = service.boardoneView(b_id); //게시판 테이블에서 글번호가져와서 model에 넣고 jsp화면으로 보내기
		b_id = Integer.parseInt(boarddto.getB_id());
		
		//게시글 조회수
		int cnt  = boarddto.getB_viewcnt()+1;
		service.updateViewCnt(b_id, cnt); //조회수 함수 불러오기
		
		model.addAttribute("board", boarddto);

		return "/boardOneview";
	}
	
	/* -------------------------원글 수정----------------------------*/
	@GetMapping("/updateBoard")
	public String updateBoard() {
		
		return"updateBoard";
	}
	
	@RequestMapping(value = "/updateBoard", method = RequestMethod.POST)
	public String updateBoard(@ModelAttribute("boardForm") BoardDTO boarddto, Model model) throws Exception {
		
		service.updateBoard(boarddto);
		model.addAttribute("board",boarddto);
		
		int b_id = Integer.parseInt(boarddto.getB_id());
	
	    return "redirect:/boardOneview?b_id=" + b_id;
	}
	
}
