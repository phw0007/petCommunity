package com.care.project.ashop;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.care.project.aboard.ABoardDTO;

@Mapper
public interface AShopMapper {

	void insertShop(AShopDTO shopDto);

	AShopDTO checkShop(AShopDTO shopDto);

	ArrayList<AShopDTO> shopData(@Param("begin")int begin, @Param("end")int end,
			@Param("select")String select, @Param("search")String search);

	int count(@Param("select")String select, @Param("search")String search);

	AShopDTO ashopInfo(@Param("name")String name, @Param("category")String category, 
			@Param("company")String company);

	void updateShopImage(AShopDTO shopDto);

	void updateShop(AShopDTO shopDto);

}
