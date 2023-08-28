package com.care.project.ainfo;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.care.project.aboard.ABoardDTO;

@Mapper
public interface AInfoMapper {

	ArrayList<AInfoDTO> AInfoData(@Param("begin")int begin, @Param("end")int end, 
			@Param("select")String select, @Param("search")String search);

	int count(@Param("select")String select, @Param("search")String search);

	ArrayList<AInfoDTO> infoCheck();

	void insertInfo(@Param("subjectCategory")String subjectCategory, 
			@Param("title")String title, @Param("venue")String venue, 
			@Param("reference")String reference, @Param("source")String source);

	AInfoDTO ainfoData(@Param("name")String name, @Param("category")String category, 
			@Param("address")String address);

	void ainfoUpdateProc(AInfoDTO info);

	void ainfoDelete(int no);

	void ainfoNoUpdate(int no);

	ArrayList<AInfoDTO> getInfo(@Param("begin")int begin, @Param("end")int end);

}
