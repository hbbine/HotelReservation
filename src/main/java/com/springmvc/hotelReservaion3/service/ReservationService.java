package com.springmvc.hotelReservaion3.service;

import java.util.Date;
import java.util.List;

import com.springmvc.hotelReservation3.dto.ReservationDTO;

public interface ReservationService {

	public void reservationInsert(ReservationDTO reservationDTO);
	
	public List <ReservationDTO> getAllReservation();
	
	//reservation check
	public int reservationCheck(String r_type, String formattedBeginDate, String formattedEndDate) throws Exception;
	
	//reservation personal List
	public List<ReservationDTO> getPersonalReservaionList(String m_id);
}
