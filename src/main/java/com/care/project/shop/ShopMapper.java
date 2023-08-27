package com.care.project.shop;

import java.util.ArrayList;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.care.project.ashop.AShopDTO;


@Mapper
public interface ShopMapper {

	ArrayList<ShopDTO> shopData(@Param("begin")int begin, @Param("end")int end, 
			@Param("select")String select, @Param("search")String search, @Param("category")String category);

	int count(@Param("select")String select, @Param("search")String search, @Param("category")String category);

	ShopDTO getProductDetails(int productId);

	void addToCart(CartDTO cartItem);

	List<CartDTO> getCartItems(@Param("id") String id);
	
	void removeSelectedItems(@Param("id") String id, @Param("productId") int productId);

	void shopOrder(AShopDTO shopDto);

	AShopDTO shopOrderDate(String writeDate);

	void shippinData(AShopDTO shopDto);

	AShopDTO getOrderData(@Param("id")String id, @Param("writeDate")String writeDate);

	CartDTO peoductCheck(CartDTO cartItem);

	CartDTO getSelectCart(@Param("id")String id, @Param("productId")String productId);

	void shippinCartData(CartDTO cartDto);

	void updateToCart(CartDTO cartDto);

	void updateInventory(@Param("no")int no, @Param("inventory")int inventory);

	
}

