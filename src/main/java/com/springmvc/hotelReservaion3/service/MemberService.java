package com.springmvc.hotelReservaion3.service;

import com.springmvc.hotelReservation3.dto.MemberDTO;

public interface MemberService {
	
	//회원가입
	public void memberJoin(MemberDTO dto) throws Exception;
	
	//로그인
	public MemberDTO Login(MemberDTO dto);
	
	//아이디 중복체크
	public int idCheck(String memberId) throws Exception;
	
	
}
