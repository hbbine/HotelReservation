package com.springmvc.hotelReservaion3.service;

import java.util.List;

import com.springmvc.hotelReservation3.dto.BoardDTO;


public interface BoardService {

	//게시판 글쓰기
	public void insertBoard(BoardDTO dto) throws Exception;
	
	//게시판 목록
	public List<BoardDTO> getAllBoardList();
	
	//게시판 원글 보기
	public BoardDTO boardoneView (int id);
	
	//게시판 조회수
	public void updateViewCnt(int id, int cnt);
	
	//게시판 수정
	public void updateBoard(BoardDTO dto) throws Exception;

}
