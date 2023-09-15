package com.springmvc.hotelReservaion3.service;

import java.util.List;

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

	@Override
	public List<BoardDTO> getAllBoardList() {
		return mapper.getAllBoardList();
	}

	@Override
	public BoardDTO boardoneView(int id) {
		
		return mapper.oneView(id);
	}

	@Override
	public void updateViewCnt(int id, int cnt) {
		mapper.updateViewCnt(id, cnt);
	}

	@Override
	public void updateBoard(BoardDTO dto) throws Exception {
		mapper.updateBoard(dto);
		
	}

	@Override
	public void deleteBoard(int b_id) {
		mapper.deleteBoard(b_id);
		
	}

	@Override
	public void updateAdminPost(String m_id) {
		mapper.updateAdminPost(m_id);
		
	}


	
	
	
	
	
}
