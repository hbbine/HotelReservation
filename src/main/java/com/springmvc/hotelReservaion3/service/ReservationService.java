package com.springmvc.hotelReservaion3.service;

import java.util.List;

import com.springmvc.hotelReservation3.dto.ReservationDTO;

public interface ReservationService {

	public void reservationInsert(ReservationDTO reservationDTO);
	
	public List <ReservationDTO> getAllReservation();
	
	
}
