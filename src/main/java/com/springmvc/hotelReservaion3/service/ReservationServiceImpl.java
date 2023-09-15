package com.springmvc.hotelReservaion3.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.hotelReservation3.dto.ReservationDTO;
import com.springmvc.hotelReservation3.repository.ReservationRepository;
import com.springmvc.mapper.ReservationMapper;


@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository repository;
	
	@Autowired
	private ReservationMapper mapper;
	
	@Override
	public void reservationInsert(ReservationDTO reservationDTO) {
		repository.reservationInsert(reservationDTO);
	}

	@Override
	public List<ReservationDTO> getAllReservation() {
		return repository.getAllReservation();
		
	}
	@Override
	public List<ReservationDTO> getPersonalReservaionList(String m_id) {
		
		return mapper.getPersonalReservaionList(m_id);
	}

	@Override
	public int reservationCheck(String r_type, String formattedBeginDate, String formattedEndDate) throws Exception {
		
		return mapper.reservationCheck(r_type, formattedBeginDate, formattedEndDate);
	}


	

	
	
	
}
