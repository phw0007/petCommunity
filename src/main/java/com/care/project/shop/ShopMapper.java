package com.care.project.shop;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.care.project.ashop.AShopDTO;

@Mapper
public interface ShopMapper {

	ArrayList<ShopDTO> shopData(@Param("begin")int begin, @Param("end")int end, 
			@Param("select")String select, @Param("search")String search, @Param("category")String category);

	int count(@Param("select")String select, @Param("search")String search, @Param("category")String category);
	
	ShopDTO getProductDetails(int productId);

	void shopOrder(AShopDTO shopDto);

	AShopDTO shopOrderDate(String writeDate);

	void shippinData(AShopDTO shopDto);

	AShopDTO getOrderData(@Param("id")String id, @Param("writeDate")String writeDate);


	
}
