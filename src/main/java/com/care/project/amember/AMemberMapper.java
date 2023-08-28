package com.care.project.amember;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.care.project.aboard.ABoardDTO;
import com.care.project.ainfo.AInfoDTO;
import com.care.project.aphoto.APhotoDTO;
import com.care.project.ashop.AShopDTO;

@Mapper
public interface AMemberMapper {
	ArrayList<AMemberDTO> memberData(@Param("begin")int begin, @Param("end")int end, 
			@Param("select")String select, @Param("search")String search);

	int count(@Param("select")String select, @Param("search")String search);

	AMemberDTO amemberInfo(String id);

	void memberDelete(String name);

	void passwordUpdata(@Param("id")String id, @Param("newPassword")String newPassword);

	AMemberDTO loginProc(String id);

	ArrayList<AMemberDTO> amaminMember(@Param("begin")int begin, @Param("end")int end);

	ArrayList<ABoardDTO> amaminBoard(@Param("begin")int begin, @Param("end")int end);

	ArrayList<AInfoDTO> amaminInfo(@Param("begin")int begin, @Param("end")int end);

	ArrayList<AShopDTO> amaminShop(@Param("begin")int begin, @Param("end")int end);

	ArrayList<APhotoDTO> amaminPhoto(@Param("begin")int begin, @Param("end")int end);

	int boardCount(String id);

	int commentCount(String id);

	int photoCount(String id);
}
