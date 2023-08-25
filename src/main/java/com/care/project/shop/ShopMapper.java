package com.care.project.shop;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.care.project.ashop.AShopDTO;
import com.care.project.member.MemberDTO;

@Mapper
public interface ShopMapper {

	ArrayList<ShopDTO> shopData(@Param("begin")int begin, @Param("end")int end, 
			@Param("select")String select, @Param("search")String search, @Param("category")String category);

	int count(@Param("select")String select, @Param("search")String search, @Param("category")String category);

	ShopDTO getProductDetails(int productId);

	void addToCart(CartDTO cartItem);

	List<CartDTO> getCartItems(@Param("id") String id);
	
	


	
	

	

}