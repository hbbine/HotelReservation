package com.springmvc.hotelReservaion3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.hotelReservation3.dto.MemberDTO;
import com.springmvc.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	//회원가입
	@Override
	public void memberJoin(MemberDTO dto) throws Exception {
		mapper.memberJoin(dto);
		
	}

	//로그인
	@Override
	public MemberDTO Login(MemberDTO dto) {
		MemberDTO DTO = mapper.Login(dto);
		return DTO;
	}

	//중복체크
	@Override
	public int idCheck(String memberId) {
		
		return mapper.idCheck(memberId);
	}

	@Override
	public void updateMyInformation(MemberDTO memberdto) throws Exception {
		mapper.updateMyInformation(memberdto);
		
	}

	@Override
	public void deleteMember(String m_id) {
		mapper.deleteMember(m_id);
		
	}

	@Override
	public List<MemberDTO> getAllMemberList() {
		return mapper.getAllMemberList();
	}



}
