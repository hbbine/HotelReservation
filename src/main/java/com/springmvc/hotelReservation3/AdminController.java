package com.springmvc.hotelReservation3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.hotelReservaion3.service.BoardService;
import com.springmvc.hotelReservaion3.service.MemberService;
import com.springmvc.hotelReservaion3.service.ReservationService;
import com.springmvc.hotelReservation3.dto.BoardDTO;
import com.springmvc.hotelReservation3.dto.MemberDTO;
import com.springmvc.hotelReservation3.dto.ReservationDTO;

@Controller
public class AdminController {

	@Autowired
	ReservationService service;
	
	@Autowired
	MemberService mservice;
	
	@Autowired
	BoardService bservice;
	
/* -------------------------관리자 예약 목록----------------------------*/
	@GetMapping("/admin/reservationList")
	public String adminReservationList(Model model) {
		List<ReservationDTO> getAdminReservationList = service.getAdminReservation();
		model.addAttribute("list", getAdminReservationList);

		return "/admin/reservationList";
	}
	
/* -------------------------관리자 예약 수정----------------------------*/
	
	@GetMapping("/admin/updateReservation")
	public String updateReservation(Model model, @RequestParam("r_id") int r_id,HttpServletRequest request ) {
		
		//현재 로그인된 세션 정보
	    MemberDTO memberdto = (MemberDTO) request.getSession().getAttribute("LoginDTO");
	    if(memberdto != null && memberdto.getM_id() != null) {
	    	//r_id를 가지고 예약내역1개 가져옴
	    	ReservationDTO reservationdto = service.adminOneView(r_id);
	    	
	    	//가져온 예약내역을 jsp 폼으로 보내줌
	    	model.addAttribute("reservationForm", reservationdto);
	    	return"/admin/updateReservation";	
	    }else {
	    	//만약 로그인 정보가 없으면 로그인 페이지로 ㄱㄱ
	    	return "redirect:/login";
	    }
	}
	
	
	@RequestMapping(value = "/admin/updateReservation", method = RequestMethod.POST)
	public String updateReservation(@ModelAttribute("reservationForm") ReservationDTO reservationdto, Model model) throws Exception{
		
		// 체크인 체크아웃 날짜간 차이를 구한다
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // 내가 원하는 날짜 형식을 지정 (포맷)
		Date beginDate = formatter.parse(reservationdto.getR_checkin()); // 체크인
		Date endDate = formatter.parse(reservationdto.getR_checkout()); // 체크아웃
		long diff = endDate.getTime() - beginDate.getTime(); // 체크아웃 - 체크인 시간차이 
		long diffDays = diff / (24 * 60 * 60 * 1000);// 날짜 계산 하루예약은 0이므로 +1해준다.

		// 날짜를 문자열로 변환 (Date 형식을 String으로 받기위해 변수 설정함)
		String formattedBeginDate = formatter.format(beginDate);
		String formattedEndDate = formatter.format(endDate);
		
		//숙박기간에 따른 방가격 설정
		String roomtype = reservationdto.getR_type();

		int roomPrice = 0;
		if (roomtype.equals("1")) {
			roomPrice = 800000;
		} else if (roomtype.equals("2")) {
			roomPrice = 500000;
		} else {
			roomPrice = 200000;
		}
		int totalPrice = roomPrice * (int) diffDays;
		reservationdto.setR_price(totalPrice);
		
		// 예약 중복 체크
		System.out.println("예약중복체크 함수 들어옴");
		int result = service.reservationCheck(roomtype, formattedBeginDate, formattedEndDate);

		if(result != 0) {
			String alertScript = "중복예약입니다";
	        model.addAttribute("alertScript", alertScript);
	        System.out.println("중복예약");
	        int r_id = reservationdto.getR_id();
	        return "redirect:/admin/updateReservation?r_id=" +r_id; 
		}else {
			//update함수 실행
			service.updateReservation(reservationdto);
			model.addAttribute("reservation", reservationdto);
			System.out.println("관리자 예약 업데이트 중복없음");
			return "redirect:/admin/reservationList";
		}	
	}
	
/* -------------------------관리자 예약 삭제----------------------------*/
	
	@GetMapping(value = "/admin/deleteReservation")
	public String deleteReservation(Model model, @RequestParam("r_id") int r_id, HttpServletRequest request) throws Exception {
	    // 지금 로그인된 세션 정보
	    MemberDTO memberdto = (MemberDTO) request.getSession().getAttribute("LoginDTO");

	    // r_id를 통해 예약 정보를 조회
	    ReservationDTO reservationdto = service.adminOneView(r_id);

	    if (reservationdto != null) { // 예약 정보가 null이 아닌 경우
	        // 예약자와 현재 로그인된 사용자가 일치하는지 또는 관리자인지 확인
	        if (memberdto != null && memberdto.getM_id() != null && (memberdto.getM_id().equals("admin") || memberdto.getM_id().equals(reservationdto.getM_id()))) {
	            service.deleteReservation(r_id);
	            System.out.println(reservationdto.getM_id() + "님 예약 삭제");
	            return "redirect:/admin/reservationList";
	        } else {
	            String alertScript = "alert('로그인 후에 삭제할 수 있습니다.');";
	            model.addAttribute("alertScript", alertScript);
	            return "redirect:/admin/updateReservation?r_id=" + r_id;
	        }
	    } else {
	        // 예약 정보를 찾을 수 없는 경우에 대한 처리
	        // 예를 들어, 예약을 찾을 수 없다는 메시지를 보여줄 수 있습니다.
	        String alertScript = "alert('삭제할 예약을 찾을 수 없습니다.');";
	        model.addAttribute("alertScript", alertScript);
	        return "redirect:/admin/reservationList";
	    }
	}
/* -------------------------관리자 회원정보 목록----------------------------*/

	@GetMapping(value = "/admin/memberInfo")
	public String adminMemberInfo(Model model) {
		
		List<MemberDTO> getAdminMemberList = mservice.getAllMemberList();
		model.addAttribute("list", getAdminMemberList);

		return "/admin/memberInfo";
	}
	
/* -------------------------관리자 회원정보 삭제----------------------------*/
	
	@GetMapping(value = "/admin/deleteMember")
	public String deleteMember(Model model, @RequestParam ("m_id") String m_id ) {
		
		System.out.println(m_id + "님 회원정보 관리자 권한으로 삭제");
		mservice.deleteMember(m_id);
		
		return "redirect:/admin/memberInfo";
		
	}
	
/* -------------------------관리자 공지 목록 불러오기----------------------------*/
	
	@GetMapping(value = "/admin/adminPost")
	public String adminPost(Model model) {
		
		List<BoardDTO> getAdminPost = bservice.getAllAdminPost();
		model.addAttribute("list", getAdminPost);

		return "/admin/adminPost";
	}
	
/* -------------------------관리자 공지 원글 보기----------------------------*/
	
	@GetMapping("/admin/adminPostOneview") //화면 불러오기전 가져올 값들
	public String boardOneview(Model model, @RequestParam("b_id") int b_id ) {
		
		//게시글 정보 가져오기
		BoardDTO boarddto = bservice.adminOneview(b_id); //게시판 테이블에서 글번호가져와서 model에 넣고 jsp화면으로 보내기
		
		//게시글 조회수
		int cnt = boarddto.getB_viewcnt()+1;
		bservice.updateViewCnt(b_id, cnt); //조회수 함수 불러오기
		
		model.addAttribute("board", boarddto);

		return "/admin/adminPostOneview";
	}
	
/* -------------------------관리자 공지 원글 수정----------------------------*/
	
	@GetMapping("/admin/updateAdminPost")
	public String updateAdminPost(Model model, @RequestParam("b_id") int b_id) {
		
		//b_id를 통해 게시글을 찾아서 BoardDTO형태의 boarddto에 넣고 그걸 model을 통해 'boardform'이라는 이름으로 보내주기
		BoardDTO boarddto = bservice.boardoneView(b_id);
		model.addAttribute("boardForm", boarddto);

		return "/admin/updateAdminPost";
	}
	
	@RequestMapping(value = "/admin/updateAdminPost", method = RequestMethod.POST)
	public String updateAdminPost(@ModelAttribute("boardForm") BoardDTO boarddto, Model model, HttpServletRequest request) throws Exception{
		
		// 현재 로그인된 세션 정보
	    MemberDTO memberdto = (MemberDTO) request.getSession().getAttribute("LoginDTO");
		
		int b_id = boarddto.getB_id();
		bservice.updateBoard(boarddto);
		bservice.updateAdminPost(memberdto.getM_id());
		
		return "redirect:/admin/adminPostOneview?b_id=" + b_id;
	}
	
/* -------------------------관리자 공지 삭제----------------------------*/		
	@GetMapping(value = "/admin/deleteAdminPost")
	public String deleteAdminPost(Model model, @RequestParam("b_id") int b_id, HttpServletRequest request) throws Exception{
		
		//지금 로그인된 세션 정보
	    MemberDTO memberdto = (MemberDTO) request.getSession().getAttribute("LoginDTO");
	    
	    if(memberdto == null) {
	    	String alertScript = "alert('로그인 후에 삭제할 수 있습니다.');";
	        model.addAttribute("alertScript", alertScript);
	        return "redirect:/admin/adminPostOneview?b_id=" + b_id;
	    }else {
	    	bservice.deleteBoard(b_id);
			return "redirect:/admin/adminPost"; 
	    }
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
