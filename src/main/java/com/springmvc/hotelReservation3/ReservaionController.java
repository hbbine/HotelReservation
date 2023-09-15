package com.springmvc.hotelReservation3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.springmvc.hotelReservaion3.service.ReservationService;
import com.springmvc.hotelReservation3.dto.BoardDTO;
import com.springmvc.hotelReservation3.dto.MemberDTO;
import com.springmvc.hotelReservation3.dto.ReservationDTO;

@Controller
public class ReservaionController {

	@Autowired
	ReservationService service;
	private String userID;
	
	//예약 목록
	@GetMapping("/reservationList")
	public String reservation(Model model) {
		List<ReservationDTO> allReservaionList = service.getAllReservation();
		model.addAttribute("allReservaionList", allReservaionList);
				
		return "/reservationList";
	}

	//예약하기
	@GetMapping("/booking")
	public String doReservation(Model model, ReservationDTO reservationDTO, HttpServletRequest request) {
		model.addAttribute("reservationForm", new ReservationDTO());
		MemberDTO memberdto = (MemberDTO) request.getSession().getAttribute("LoginDTO");
		
	    if (memberdto != null) {
	        // 로그인된 상태이므로 예약 페이지를 표시
	        model.addAttribute("m_id", memberdto.getM_id());
	        System.out.println("세션 값 확인: " + memberdto.getM_id());
	        return "booking";
	    } else {
	    	
	        // 로그인되지 않은 상태이므로 로그인 페이지로 이동
	        return "redirect:/login";
	    }
		
		
//		model.addAttribute("m_id", memberdto.getM_id());
//		System.out.println("세션 값 확인 : " + memberdto.getM_id());
//		reservationDTO.setM_id((String) session.getAttribute("m_id"));
	}
	
	@RequestMapping(value = "/booking", method = RequestMethod.POST)
	public String reservation(@ModelAttribute("reservationForm") ReservationDTO reservationDTO, HttpSession session,
		Model model) throws Exception {

		//reservationDTO.setM_id((String) session.getAttribute("m_id"));
		

		// 체크인 체크아웃 날짜간 차이를 구한다
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // 내가 원하는 날짜 형식을 지정 (포맷)
		Date beginDate = formatter.parse(reservationDTO.getR_checkin()); // 체크인
		Date endDate = formatter.parse(reservationDTO.getR_checkout()); // 체크아웃
		long diff = endDate.getTime() - beginDate.getTime(); // 체크아웃 - 체크인 시간차이 
		long diffDays = diff / (24 * 60 * 60 * 1000);// 날짜 계산 하루예약은 0이므로 +1해준다.
		
		// 날짜를 문자열로 변환 (Date 형식을 String으로 받기위해 변수 설정함)
		String formattedBeginDate = formatter.format(beginDate);
		String formattedEndDate = formatter.format(endDate);

		System.out.println("----Booking----");
		System.out.println("숙박기간" +diffDays);

		String roomtype = reservationDTO.getR_type();

		System.out.println("roomtype" + roomtype);

		int roomPrice = 0;
		if (roomtype.equals("1")) {
			roomPrice = 800000;
		} else if (roomtype.equals("2")) {
			roomPrice = 500000;
		} else {
			roomPrice = 200000;
		}
		int totalPrice = roomPrice * (int) diffDays;
		reservationDTO.setR_price(totalPrice);

		System.out.println("reservation total price" +totalPrice);

		
		
		//예약 중복 체크
		System.out.println("예약중복체크 함수 들어옴");
		int result = service.reservationCheck(roomtype, formattedBeginDate, formattedEndDate);
		System.out.println("방타입 : " + roomtype + " 체크인 : " + formattedBeginDate + " 체크아웃 : " + formattedEndDate);
		System.out.println("중복결과 : "+ result);
		if(result != 0) {
			String alertScript = "중복예약입니다";
	        model.addAttribute("alertScript", alertScript);
	        return "redirect:/booking";  
		}else {
			service.reservationInsert(reservationDTO);
			model.addAttribute("dto", reservationDTO);
			return "redirect:/reservationList";
		}
	}

/* -------------------------Personal reservation List ----------------------------*/

	@GetMapping("/myReservation")
	public String getPersonalReservationList(HttpServletRequest request, Model model) {
		
	    // 지금 로그인된 세션 정보
	    MemberDTO memberdto = (MemberDTO) request.getSession().getAttribute("LoginDTO");
	    System.out.println("My Reservation <" + memberdto.getM_id() + "> check");

	    if (memberdto != null && memberdto.getM_id() != null) {
	        List<ReservationDTO> getPersonalReservationList = service.getPersonalReservaionList(memberdto.getM_id());
	        model.addAttribute("myReservation", getPersonalReservationList);
	    }

	    return "/myReservation";
	}
	
}
