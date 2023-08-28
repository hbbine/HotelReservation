package com.springmvc.hotelReservation3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.hotelReservaion3.service.ReservationService;
import com.springmvc.hotelReservation3.dto.ReservationDTO;

@Controller
public class ReservaionController {

	@Autowired
	ReservationService service;
	
//예약 목록
	@GetMapping("/reservationList")
	public String reservation(Model model) {
		List<ReservationDTO> allReservaionList = service.getAllReservation();
		model.addAttribute("allReservaionList", allReservaionList);
		
		System.out.println();
		
		
		
		
		return "/reservationList";
	}

//예약하기
	@GetMapping("/doReservation")
	public String doReservation(Model model) {
		model.addAttribute("reservationForm", new ReservationDTO());
		return "/doReservation";
	}
	
	@RequestMapping(value = "/doReservation", method = RequestMethod.POST)
	public String reservation(@ModelAttribute("reservationForm") ReservationDTO reservationDTO, HttpSession session, Model model) throws ParseException {
		//reservationDTO.setM_id((String) session.getAttribute("m_id"));

		// 체크인 체크아웃 날짜간 차이를 구한다
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // 내가 원하는 날짜 형식을 지정 (포맷)
		Date beginDate = formatter.parse(reservationDTO.getR_checkin()); // 체크인
		Date endDate = formatter.parse(reservationDTO.getR_checkout()); // 체크아웃
		long diff = endDate.getTime() - beginDate.getTime(); // 체크아웃 - 체크인 시간차이 
		long diffDays = diff / (24 * 60 * 60 * 1000);// 날짜 계산 하루예약은 0이므로 +1해준다.
		
		System.out.println(diffDays);

		String roomtype = reservationDTO.getR_type();
		
		System.out.println(roomtype);
		
		int roomPrice = 0;
		if(roomtype.equals("1")) {
			roomPrice = 800000;
		}else if(roomtype.equals("2")) {
			roomPrice = 500000;
		}else {
			roomPrice = 200000;
		}
		int totalPrice = roomPrice * (int) diffDays;
		reservationDTO.setR_price(totalPrice);
		
		System.out.println(totalPrice);
		
		//결제승인
		reservationDTO.setCONFIRMATION_PAYMENT(false);

		service.reservationInsert(reservationDTO);
		model.addAttribute("dto", reservationDTO);
		return "redirect:/reservationList";

	}
	
//

}
