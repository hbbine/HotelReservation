package com.springmvc.hotelReservaion3.service;

import com.springmvc.hotelReservation3.dto.BoardDTO;


public interface BoardService {

	//게시판 글쓰기
	public void insertBoard(BoardDTO dto) throws Exception;
}
