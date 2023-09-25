package com.springmvc.hotelReservation3;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.hotelReservaion3.service.BoardService;
import com.springmvc.hotelReservation3.dto.BoardDTO;
import com.springmvc.hotelReservation3.dto.FileDTO;
import com.springmvc.hotelReservation3.dto.MemberDTO;
import com.springmvc.hotelReservation3.dto.PageDTO;
import com.springmvc.hotelReservation3.dto.ReservationDTO;
import com.springmvc.hotelReservation3.utils.UploadFileUtils;

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
		HttpServletRequest request,	Model model, MultipartFile file) throws Exception {
		
		//현재 로그인 정보를 MemberDTO에 담아서 가져옴
		MemberDTO memberdto = (MemberDTO) session.getAttribute("LoginDTO");
	    String m_id = memberdto.getM_id();
	    
	    //파일업로드
		String uploadPath = "C:\\SpringWorkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\HotelReservaion3\\resources\\imgUpload";
		String imgUploadPath = uploadPath + java.io.File.separator;

		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file != null) {
			 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
			} else {
			 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
			}
		
		boarddto.setB_img(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		boarddto.setB_thumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
	    
	    service.insertBoard(boarddto);
	    
	    System.out.println("업로드경로" +uploadPath);
		System.out.println("이미지경로" +imgUploadPath);
		System.out.println("업로드날짜"+ ymdPath);
		System.out.println("파일이름" + fileName);
		
		//만약 관리자 아이디라면 post에 권한 추가
		if(m_id.equals("admin")) { 
			service.updateAdminPost(m_id);
		}
		
		// 게시물 작성자 설정
	    boarddto.setM_id(m_id);
		model.addAttribute("dto", boarddto);
		
		return "redirect:/boardListSearch";	
	}

/* -------------------------목록----------------------------*/
	
	@GetMapping("/boardList")
	public String boardList(Model model) {
		List<BoardDTO> getallboardList = service.getAllBoardList();
		model.addAttribute("boardList", getallboardList);
		return "/boardListSearch";
	}
	
/* -------------------------원글 보기----------------------------*/
	
	@GetMapping("/boardOneview") //화면 불러오기전 가져올 값들
	public String boardOneview(Model model, @RequestParam("b_id") int b_id ) {
		
		//게시글 정보 가져오기
		BoardDTO boarddto = service.boardoneView(b_id); //게시판 테이블에서 글번호가져와서 model에 넣고 jsp화면으로 보내기
//		b_id = boarddto.getB_id();
		
		//게시글 조회수
		int cnt = boarddto.getB_viewcnt()+1;
		service.updateViewCnt(b_id, cnt); //조회수 함수 불러오기
		
		model.addAttribute("board", boarddto);

		return "/boardOneview";
	}
	
/* -------------------------원글 수정----------------------------*/
	
	@GetMapping("/updateBoard")
	public String updateBoard(Model model, @RequestParam("b_id") int b_id, HttpServletRequest request) { //requestParam을 이용해서 url에 있는 id 값을 받아줌
		// 현재 로그인된 세션 정보
	    MemberDTO memberdto = (MemberDTO) request.getSession().getAttribute("LoginDTO");
	    
	    //b_id를 통해 글쓴사람 id를 알아냄
	    BoardDTO boarddto = service.boardoneView(b_id); //param으로 받은 id값을 이용해서 원글보기할때 썼던 함수를 실행하여 boarddto에 담아줌
	   
	    // 비회원인경우
	    if(memberdto == null) {
	    	 String alertScript = "alert('로그인 후에 수정 할 수 있습니다.');";
	         model.addAttribute("alertScript", alertScript);
	         return "redirect:/boardOneview?b_id=" + b_id;
	    }
	    
	    // 현재 사용자의 ID와 게시물 작성자의 ID 또는 'admin'을 비교하여 권한 확인
	    if (boarddto.getM_id().equals(memberdto.getM_id()) || memberdto.getM_id().equals("admin")) {
			model.addAttribute("boardForm", boarddto ); //담은 boarddto를 boardForm 폼으로 보내주면 이전에 썼던 글이 생성되어있음
			return"updateBoard";
	    } else {
	        String alertScript = "alert('수정 권한이 없습니다.');";
	        model.addAttribute("alertScript", alertScript);

	        System.out.println("글쓴이(" + boarddto.getM_id() + ")와 로그인 ID(" + memberdto.getM_id() + ")가 달라서 수정 불가능");
	        return "redirect:/boardOneview?b_id=" + b_id;
	    }
	}
	
	@RequestMapping(value = "/updateBoard", method = RequestMethod.POST)
	public String updateBoard(@ModelAttribute("boardForm") BoardDTO boarddto, Model model) throws Exception {
	    
	    int b_id = boarddto.getB_id();
	    service.updateBoard(boarddto); // 게시물 수정 함수 호출
	    model.addAttribute("board", boarddto);
	    

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
	        return "redirect:/boardListSearch";    
	    } else {
	    	 String alertScript = "alert('삭제 권한이 없습니다');";
	         model.addAttribute("alertScript", alertScript);
	         
	    	System.out.println("글쓴이("+ boarddto.getM_id() + ")와 로그인id(" + memberdto.getM_id() + ")가 달라서 삭제불가능");
	        return "redirect:/boardOneview?b_id=" + b_id;
	    }
	}
	
/* -------------------------게시판 목록보기 with page----------------------------*/	
	
	@GetMapping(value = "/boardListPage")
	public ModelAndView getBoard(PageDTO pagedto) throws Exception{
		
		System.out.println("boardListPage" +pagedto.getStartRow());
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> list = service.getPageBoardList(pagedto);
		
		mv.addObject("list", list);
		mv.addObject("pagedto", pagedto);
		mv.setViewName("/boardListPage");
		
		return mv;	
	}
	
/* -------------------------게시판 검색 ----------------------------*/	
	
	//게시판 아무검색없을때
//	@GetMapping(value="/boardListSearch")
//	public ModelAndView boardSearch(HttpSession session, PageDTO pagedto, 
//						@RequestParam(value = "searchType", defaultValue = "title") String searchType, 
//						@RequestParam(value = "keyword", defaultValue = "") String keyword) throws Exception{
//		
//		ModelAndView mv = new ModelAndView();
//		List<BoardDTO> list = service.listPageSearch(pagedto, searchType, keyword);
//		
//		
//		
//		// 검색 결과에 따라 새로운 PageDTO 생성
//	    PageDTO newPagedto = new PageDTO();
//	    newPagedto.setPage(pagedto.getPage()); // 현재 페이지 정보는 유지
//	    newPagedto.setSearchType(searchType);
//	    newPagedto.setKeyword(keyword);
//	    long totalCount = service.getSearchCount(searchType, keyword);
//	    newPagedto.setNum(totalCount);  // 검색 결과에 따라 전체 게시물 수 변경
//	    System.out.println(totalCount);
//	    
//	    //세션에 pagedto를 저장...근데 유지가 안되서 검색한게 일시적임
//        session.setAttribute("pagedto", pagedto);
//		
//		mv.addObject("list", list);
//		mv.addObject("pagedto", pagedto);
//		mv.setViewName("/boardListSearch");
//		
//		return mv;	
//
//	}

	//게시판 검색결과대로 키워드랑 서치타입넣고 새롭게 newpageDto만들어서 페이지 나오게 함
	@GetMapping(value="/boardListSearch2")
	public ModelAndView boardSearch2(HttpSession session, PageDTO pagedto, 
	                    @RequestParam(value = "searchType", defaultValue = "title") String searchType, 
	                    @RequestParam(value = "keyword", defaultValue = "") String keyword) throws Exception{
	    
	    ModelAndView mv = new ModelAndView();
	    List<BoardDTO> list = service.listPageSearch(pagedto, searchType, keyword);
	    PageDTO newPagedto = new PageDTO();//검색결과 있을때 새롭게 pagedto 설정하려고 객체 선언
	    long totalCount = service.getSearchCount(searchType, keyword); //검색결과에 따른 게시글 갯수 함수 실행
	    
	    
	    if(totalCount == 0) {
	    	//검색결과 없을때 받아온 pagedto초기화
	    	pagedto = new PageDTO();
	    } else {
	    	//검색결과 있을때 새롭게 페이지 설정
	    	newPagedto.setPage(pagedto.getPage()); // 현재 페이지 정보는 유지
		    newPagedto.setSearchType(searchType);
		    newPagedto.setKeyword(keyword);
		    newPagedto.setNum(totalCount);  // 검색 결과에 따라 전체 게시물 수 변경
	    }

	    System.out.println(totalCount);
	    System.out.println("search2 : newpagedto startNum " + newPagedto.getStartNum());
	    System.out.println("search2 : newpagedto lastNum " + newPagedto.getLastNum());
	    
	    // 세션에 newPagedto를 저장하여 새로운 페이지 정보를 유지
	    session.setAttribute("newPagedto", newPagedto);
	    
	    // 모델에 검색결과에 나온 게시글들과 새로 생성한 newPagedto를 추가
	    mv.addObject("list", list);
	    
	    if(totalCount == 0) {
	    	mv.addObject("newPagedto", pagedto); //검색결과 없을때 초기화한 pagedto보내줌
	    }else {
	    	mv.addObject("newPagedto", newPagedto); //검색결과 잇으면 새롭게 설정한 pagedto보내기
	    }
	     
	    mv.setViewName("/boardListSearch2");
	    
	    return mv;    
	}

}


