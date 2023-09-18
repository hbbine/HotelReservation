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
		List<StatusDTO> statusList = new ArrayList<StatusDTO>(); 
		
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
		
		// 예약 정보 반복하면서 상태 업데이트
	    for (ReservationDTO reservation : reservationList) {
	    	 System.out.println("Reservation: " + reservation.getR_checkin() + " - " + reservation.getR_id());
	    	
	        for (StatusDTO status : statusList) {
	            if (status.getS_checkin().equals(reservation.getR_checkin())) {
	                switch (reservation.getR_type()) {
	                    case "1":
	                        status.setS_royalSweet("예약불가능");
	                        break;
	                    case "2":
	                        status.setS_deluxe("예약불가능");
	                        break;
	                    case "3":
	                        status.setS_standard("예약불가능");
	                        break;
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
