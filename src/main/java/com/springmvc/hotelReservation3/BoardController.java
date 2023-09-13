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
import org.springframework.web.bind.annotation.ResponseBody;
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
		b_id = boarddto.getB_id();
		
		//게시글 조회수
		int cnt  = boarddto.getB_viewcnt()+1;
		service.updateViewCnt(b_id, cnt); //조회수 함수 불러오기
		
		model.addAttribute("board", boarddto);

		return "/boardOneview";
	}
	
/* -------------------------원글 수정----------------------------*/
	
	@GetMapping("/updateBoard")
	public String updateBoard(Model model, @RequestParam("b_id") int b_id ) { //requestParam을 이용해서 url에 있는 id 값을 받아줌
		BoardDTO boarddto = service.boardoneView(b_id); //param으로 받은 id값을 이용해서 원글보기할때 썼던 함수를 실행하여 boarddto에 담아줌
		model.addAttribute("boardForm", boarddto ); //담은 boarddto를 boardForm 폼으로 보내주면 이전에 썼던 글이 생성되어있음
		return"updateBoard";
	}
	
	@RequestMapping(value = "/updateBoard", method = RequestMethod.POST)
	public String updateBoard(@ModelAttribute("boardForm") BoardDTO boarddto, Model model) throws Exception { //updateBoardForm이라는 객채를 BoardDTO에 받음
		
		service.updateBoard(boarddto);
		model.addAttribute("board",boarddto);
		
		int b_id = boarddto.getB_id();
	
	    return "redirect:/boardOneview?b_id=" + b_id;
	}
	
/* -------------------------원글 삭제----------------------------*/	
	
	@GetMapping(value = "/deleteBoard") //화면 불러오고 나서 다시 입력할 값들
	public String deleteBoard(Model model, @RequestParam("b_id") int b_id) throws Exception {
		service.deleteBoard(b_id);
		
		return "redirect:/boardList";	
	}
	
	
}

	
	
/*
 * (value = "/deleteCheck", method = RequestMethod.POST) public String
 * deleteBoard(Model model, @RequestParam("b_id") int
 * b_id, @RequestParam("password") String password, HttpServletRequest request,
 * HttpSession session) { BoardDTO boarddto = service.boardoneView(b_id); String
 * id = boarddto.getM_id(); String sessionid = (String)
 * session.getAttribute("id");
 * 
 * if (sessionid != null && sessionid.equals(id)) { if
 * (password.equals(boarddto.getM_password())) { service.deleteBoard(b_id);
 * return "redirect:/boardList"; // 삭제 성공 시 boardList로 이동 } else { return
 * "redirect:/deleteCheck?b_id=" + b_id + "&error=true"; // 비밀번호 불일치 시 에러 페이지로
 * 이동 } } else { return "redirect:/deleteCheck?b_id=" + b_id ; // 세션 아이디 불일치 시
 * 에러 페이지로 이동 } }
 * 
 * @GetMapping("/deleteCheck") public String deleteBoard(@RequestParam("b_id")
 * int b_id, Model model) { BoardDTO boarddto = service.boardoneView(b_id);
 * model.addAttribute("boarddto", boarddto); return"deleteCheck"; } }
 */

