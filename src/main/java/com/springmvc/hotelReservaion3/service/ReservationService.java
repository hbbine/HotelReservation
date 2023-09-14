package com.springmvc.hotelReservaion3.service;

import java.util.List;

import com.springmvc.hotelReservation3.dto.ReservationDTO;

public interface ReservationService {

	public void reservationInsert(ReservationDTO reservationDTO);
	
	public List <ReservationDTO> getAllReservation();
	
	//reservation check
	public int reservationCheck(String r_type, String r_checkin, String r_checkout) throws Exception;
	
	//reservation personal List
	public List<ReservationDTO> getPersonalReservaionList(String m_id);
}
