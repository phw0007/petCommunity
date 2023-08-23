package com.care.project;



import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.care.project.member.MemberDTO;

@Mapper
public interface MemberMapper {
	
	MemberDTO mloginProc(String id);

	void registerProc(MemberDTO member);
	

	int updateProc(MemberDTO member);

	void delete(String id);
	
	ArrayList<MemberDTO> memberInfo(@Param("begin")int begin, @Param("end")int end, @Param("select")String select, @Param("search")String search);
	int count(@Param("select")String select, @Param("search")String search);

	MemberDTO getMemberByUsername(String username);


	

}

	

