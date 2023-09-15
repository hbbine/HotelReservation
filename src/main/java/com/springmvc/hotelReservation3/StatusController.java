package com.springmvc.hotelReservation3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springmvc.hotelReservaion3.service.ReservationService;
import com.springmvc.hotelReservaion3.service.StatusService;
import com.springmvc.hotelReservation3.dto.ReservationDTO;
import com.springmvc.hotelReservation3.dto.StatusDTO;

@Controller
public class StatusController {

	@Autowired
	StatusService service;
	
	@Autowired
	ReservationService Rservice;
	
/* -------------------------status에 기본값 집어넣기----------------------------*/
	
	@GetMapping("/reservationList")
	public String insertStatus(Model model, StatusDTO statusdto) throws Exception {
		
		// StatusDTO 객체들을 담을 리스트 생성
		List<StatusDTO> statusList = new ArrayList<>(); 
		
		//DB에 저장된 예약
		List<ReservationDTO> reservationList = Rservice.getAllReservation();
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
		
		//초기 기본값 설정
		for (int i = 0; i < 30; i++) {
	        String s_date = dformat.format(cal.getTime());

	        // StatusDTO 객체 생성 및 설정
	        StatusDTO status = new StatusDTO("예약가능","예약가능","예약가능");
	        
	        status.setS_checkin(s_date); //날짜 똑같지만 체크인 아웃 날짜 설정
	        status.setS_checkout(s_date);

	        // 리스트에 추가
	        statusList.add(status);
	        cal.add(Calendar.DATE, 1);
	    }
		
		//날짜 초기화
		cal = Calendar.getInstance();
		
		/*
		 * //비교위해서 다시 처음부터 반복함 for(int i = 0; i < 30; i++) {
		 * 
		 * int resultR = Rservice.reservationCheck("1",
		 * statusList.get(i).getS_checkin(), statusList.get(i).getS_checkout());
		 * 
		 * if(resultR != 0) { statusList.get(i).setS_royalSweet("예약불가능"); }else {
		 * statusList.get(i).setS_royalSweet("예약가능"); }
		 * 
		 * int resultD = Rservice.reservationCheck("2",
		 * statusList.get(i).getS_checkin(), statusList.get(i).getS_checkout());
		 * 
		 * if(resultD != 0) { statusList.get(i).setS_deluxe("예약불가능"); }else {
		 * statusList.get(i).setS_deluxe("예약가능"); }
		 * 
		 * int resultS = Rservice.reservationCheck("3",
		 * statusList.get(i).getS_checkin(), statusList.get(i).getS_checkout());
		 * 
		 * if(resultS != 0) { statusList.get(i).setS_standard("예약불가능"); }else {
		 * statusList.get(i).setS_standard("예약가능"); }
		 * 
		 * System.out.println("전체예약상황 royal : " + resultR);
		 * System.out.println("전체예약상황 deluxe : " + resultD);
		 * System.out.println("전체예약상황 standard : " + resultS); }
		 */
	    // 모델에 statusList를 추가하여 뷰에서 사용할 수 있도록 함
	    model.addAttribute("statusList", statusList);

	    // 반환할 뷰 이름 리턴
	    return "reservationList";
	}
	
	
}
