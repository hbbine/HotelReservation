package com.springmvc.hotelReservaion3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.hotelReservation3.dto.BoardDTO;
import com.springmvc.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;

	@Override
	public void insertBoard(BoardDTO dto) throws Exception {
		mapper.insertBoard(dto);
		
	}
	
	
}
