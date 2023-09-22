package com.springmvc.hotelReservaion3.service;

import java.util.List;

import com.springmvc.hotelReservation3.dto.BoardDTO;
import com.springmvc.hotelReservation3.dto.PageDTO;


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
	
	//게시판 삭제
	void deleteBoard(int b_id);

	//관리자 게시글 업데이트
	void updateAdminPost(String m_id);
	
	//관리자 공지 목록
	public List<BoardDTO> getAllAdminPost();
	
	//관리자 공지 원글보기
	public BoardDTO adminOneview(int id);
	
	//게시판 페이지네이션
	List<BoardDTO> getPageBoardList(PageDTO pagedto) throws Exception;
	
	//게시판 전체 글 수
	public int getCountBoard();

	//게시판 검색 페이지
	public List<BoardDTO> listPageSearch(PageDTO pagedto, String searchType, String keyword) throws Exception;
	
	//게시판 검색에 맞는 페이지수
	public int getSearchCount(String searchType, String keyword) throws Exception;
}
