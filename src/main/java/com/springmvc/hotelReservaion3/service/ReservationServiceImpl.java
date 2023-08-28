package com.springmvc.hotelReservaion3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.hotelReservation3.dto.ReservationDTO;
import com.springmvc.hotelReservation3.repository.ReservationRepository;


@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository repository;
	
	@Override
	public void reservationInsert(ReservationDTO reservationDTO) {
		repository.reservationInsert(reservationDTO);
	}

	@Override
	public List<ReservationDTO> getAllReservation() {
		repository.getAllReservation();
		return null;
	}

	
	
}
