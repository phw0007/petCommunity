package com.care.project.amember;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AMemberMapper {
	ArrayList<AMemberDTO> memberData(@Param("begin")int begin, @Param("end")int end, 
			@Param("select")String select, @Param("search")String search);

	int count(@Param("select")String select, @Param("search")String search);

	AMemberDTO amemberInfo(String id);

	void memberDelete(String name);

	void passwordUpdata(@Param("id")String id, @Param("newPassword")String newPassword);

	AMemberDTO loginProc(String id);
}
