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
		
		
		
		for (StatusDTO status : statusList) {
			System.out.println("statusList 반복문 진입");
		    for (ReservationDTO reservation : reservationList) {
		    	System.out.println("reservation 반복문 진입");
		    	System.out.println("status 체크인 날짜 " +status.getS_checkin());
	        	System.out.println("예약테이블 체크인 날짜 " + reservation.getR_checkin());
		    	
		        if (status.getS_checkin().equals(reservation.getR_checkin())) {
		        	
		        	if ("1".equals(reservation.getR_id())) {
		        		
		        	    System.out.println("예약방번호 1 = " + reservation.getR_id());
		        	    status.setS_royalSweet("예약불가능");
		        	    
		        	} else if ("2".equals(reservation.getR_id())) {
		        		
		        	    System.out.println("예약방번호 2 = " + reservation.getR_id());
		        	    status.setS_deluxe("예약불가능");
		        	    
		        	} else {
		        		
		        	    System.out.println("예약방번호 3 = " + reservation.getR_id());
		        	    status.setS_standard("예약불가능");
		        	}
		            break; // 일치하는 예약을 찾았으므로 루프 종료
		        }
		    }
		}

	    // 모델에 statusList를 추가하여 뷰에서 사용할 수 있도록 함
	    model.addAttribute("statusList", statusList);

	    // 반환할 뷰 이름 리턴
	    return "reservationList";
	}
	
	
	
}
