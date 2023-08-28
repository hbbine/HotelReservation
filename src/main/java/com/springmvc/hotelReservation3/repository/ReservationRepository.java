package com.springmvc.hotelReservation3.repository;

import java.util.List;

import com.springmvc.hotelReservation3.dto.ReservationDTO;

public interface ReservationRepository {

	public void reservationInsert(ReservationDTO reservationDTO);
	
	public List <ReservationDTO> getAllReservation();
}
