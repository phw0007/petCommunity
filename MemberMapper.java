package com.care.project;



import org.apache.ibatis.annotations.Mapper;


import com.care.project.member.MemberDTO;

@Mapper
public interface MemberMapper {
	
	MemberDTO loginProc(String id);

	void registerProc(MemberDTO member);
	

}
