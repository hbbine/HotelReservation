package com.springmvc.hotelReservaion3.service;

import java.util.List;

import com.springmvc.hotelReservation3.dto.BoardDTO;
import com.springmvc.hotelReservation3.dto.MemberDTO;

public interface MemberService {
	
	//회원가입
	public void memberJoin(MemberDTO dto) throws Exception;
	
	//로그인
	public MemberDTO Login(MemberDTO dto);
	
	//아이디 중복체크
	public int idCheck(String memberId) throws Exception;
	
	//my information 수정
	public void updateMyInformation(MemberDTO memberdto) throws Exception;
	
	//delete member
	void deleteMember(String m_id);
	
	//회원 목록
	public List<MemberDTO> getAllMemberList();
}
