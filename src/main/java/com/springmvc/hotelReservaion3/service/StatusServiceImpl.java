package com.springmvc.hotelReservaion3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.hotelReservation3.dto.StatusDTO;
import com.springmvc.mapper.StatusMapper;

@Service
public class StatusServiceImpl implements StatusService {
	
	@Autowired
	private StatusMapper mapper;

	@Override
	public void insertStatus(StatusDTO statusdto) throws Exception {
		mapper.insertStatus(statusdto);
		
	}

}
