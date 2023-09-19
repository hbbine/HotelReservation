package com.springmvc.hotelReservaion3.service;

import java.util.Date;
import java.util.List;

import com.springmvc.hotelReservation3.dto.BoardDTO;
import com.springmvc.hotelReservation3.dto.ReservationDTO;

public interface ReservationService {

	public void reservationInsert(ReservationDTO reservationDTO);
	
	public List <ReservationDTO> getAllReservation();
	
	//reservation check
	public int reservationCheck(String r_type, String formattedBeginDate, String formattedEndDate) throws Exception;
	
	//reservation personal List
	public List<ReservationDTO> getPersonalReservaionList(String m_id);
	
	//admin reservation List
	public List <ReservationDTO> getAdminReservation();
	
	//admin 예약 수정
	public void updateReservation(ReservationDTO dto) throws Exception;

	//admin 예약 1개 보기
	public ReservationDTO adminOneView (int id);
	
	//admin 예약삭제
	void deleteReservation(int r_id);
}
