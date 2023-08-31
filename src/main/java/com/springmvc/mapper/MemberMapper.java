package com.springmvc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.springmvc.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	//insert member table
	@Insert("INSERT INTO member(m_id, m_password, m_name, m_email, m_tel) VALUES(#{m_id}, #{m_password}, #{m_name}, #{m_email}, #{m_tel})")
	public void memberJoin(MemberDTO dto);
}
