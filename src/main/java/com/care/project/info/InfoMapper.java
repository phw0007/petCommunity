package com.care.project.info;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.care.project.ainfo.AInfoDTO;

@Mapper
public interface InfoMapper {

	ArrayList<AInfoDTO> InfoData(@Param("begin")int begin, @Param("end")int end, 
			@Param("select")String select, @Param("search")String search);

	int hoscount(@Param("select")String select, @Param("search")String search);

	ArrayList<AInfoDTO> minfoCheck();

	void insertInfo(@Param("subjectCategory")String subjectCategory, 
			@Param("title")String title, @Param("venue")String venue, 
			@Param("reference")String reference, @Param("source")String source);

}
