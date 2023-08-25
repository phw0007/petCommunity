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

	AShopDTO ashopInfo(@Param("product")String product, @Param("category")String category, 
			@Param("company")String company);

	void updateShopImage(AShopDTO shopDto);

	void updateShop(AShopDTO shopDto);

	void ashopDelete(@Param("product")String product, @Param("category")String category, @Param("no")int no);

	void ashopNoUpdate(int no);

	ArrayList<AShopDTO> shopOrderData(@Param("begin")int begin, @Param("end")int end, 
			@Param("select")String select, @Param("search")String search);

	int orderCount(@Param("select")String select, @Param("search")String search);

	AShopDTO ashopOrderInfo(int no);

	ArrayList<AShopDTO> ashopOrderList(int no);

	void orderDelete(int no);

	void orderNoUpdate(int no);

	void orderListDelete(int no);

	void orderListNoUpdate(int no);

}