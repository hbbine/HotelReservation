package com.springmvc.hotelReservation3.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.hotelReservation3.dto.ReservationDTO;
import com.springmvc.mapper.ReservationMapper;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository {
	
	@Autowired
	private ReservationMapper mapper;
	private List<ReservationDTO> reservationDTO = new ArrayList<ReservationDTO>();

	@Override
	public void reservationInsert(ReservationDTO reservationDTO) {
		mapper.reservationInsert(reservationDTO);
	}

	@Override
	public List<ReservationDTO> getAllReservation() {
		reservationDTO = mapper.getAllReservation();
		return reservationDTO;
	}

}
