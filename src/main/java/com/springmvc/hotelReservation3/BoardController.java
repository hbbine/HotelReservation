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
		
		String admin = null;
	
	    if (memberdto != null) {
	    	
	    	//관리자인경우 따로 표시해서 모델에 넘김
	    	if(memberdto.getM_id().equals("admin")) {
				admin = memberdto.getM_id();
			}
	    	model.addAttribute("admin", admin);
	    	
	        // 로그인된 상태이므로 글쓰기페이지를 표시
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
	public String insertBoard(@ModelAttribute("boardForm") BoardDTO boarddto, HttpSession session,
		HttpServletRequest request,	Model model) throws Exception {
		
		//현재 로그인 정보를 MemberDTO에 담아서 가져옴
		MemberDTO memberdto = (MemberDTO) session.getAttribute("LoginDTO");
	    String m_id = memberdto.getM_id();
		
		//만약 관리자 아이디라면 post에 권한 추가
		if(m_id.equals("admin")) { 
			service.updateAdminPost(m_id);
		}
		
		// 게시물 작성자 설정
	    boarddto.setM_id(m_id);
	    
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
	
	@GetMapping(value = "/deleteBoard") 
	public String deleteBoard(Model model, @RequestParam("b_id") int b_id, HttpServletRequest request) throws Exception {
		//지금 로그인된 세션 정보
	    MemberDTO memberdto = (MemberDTO) request.getSession().getAttribute("LoginDTO");
	    
	    //b_id를 통해 글쓴사람 id를 알아냄
	    BoardDTO boarddto = service.boardoneView(b_id);
	    
	    //비회원인경우
	    if(memberdto == null) {
	    	 String alertScript = "alert('로그인 후에 삭제할 수 있습니다.');";
	         model.addAttribute("alertScript", alertScript);
	         return "redirect:/boardOneview?b_id=" + b_id;
	    }
	    
	    //회원인경우, 게시글을 작성한 사용자와 현재 로그인한 사용자의 ID가 같을 때나 관리자일때 삭제
	    if (boarddto != null && boarddto.getM_id() != null && (boarddto.getM_id().equals(memberdto.getM_id()) || memberdto.getM_id().equals("admin"))) {
	        service.deleteBoard(b_id); 
	        System.out.println("글쓴이("+ boarddto.getM_id() + ")와 로그인id(" + memberdto.getM_id() + ")가 같아서 삭제완료");
	        return "redirect:/boardList";    
	    } else {
	    	 String alertScript = "alert('삭제 권한이 없습니다');";
	         model.addAttribute("alertScript", alertScript);
	         
	    	System.out.println("글쓴이("+ boarddto.getM_id() + ")와 로그인id(" + memberdto.getM_id() + ")가 달라서 삭제불가능");
	        return "redirect:/boardOneview?b_id=" + b_id;
	    }
	}
}


