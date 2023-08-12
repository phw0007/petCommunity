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

}
