package com.springmvc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.springmvc.hotelReservation3.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	//insert member table
	@Insert("INSERT INTO member(m_id, m_password, m_name, m_email, m_tel) VALUES(#{m_id}, #{m_password}, #{m_name}, #{m_email}, #{m_tel})")
	public void memberJoin(MemberDTO dto);
	
	//login
	@Select("SELECT * FROM member WHERE m_id=#{m_id} and m_password=#{m_password}")
	public MemberDTO Login(MemberDTO dto);
	
	//id중복체크
	@Select("SELECT COUNT(*) FROM member WHERE m_id=#{memberId}")
	public int idCheck(String memberId);
}
