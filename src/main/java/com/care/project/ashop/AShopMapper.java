package com.care.project.ashop;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AShopMapper {

	void insertShop(AShopDTO shopDto);

	AShopDTO checkShop(AShopDTO shopDto);

	ArrayList<AShopDTO> shopData(@Param("begin")int begin, @Param("end")int end,
			@Param("select")String select, @Param("search")String search);

	int count(@Param("select")String select, @Param("search")String search);

}
