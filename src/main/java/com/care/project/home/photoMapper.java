package com.care.project.home;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.care.project.board.BoardDTO;


@Mapper
public interface photoMapper {

	void photoWriteProc(photoDTO photo);

	photoDTO photoContent(int no);

	void incHit(int no);

	List<photoDTO> getAllPhotos();
	
	List<Image> getAllImages();
	ArrayList<photoDTO> photoData(@Param("begin")int begin, @Param("end")int end, 
			@Param("select")String select, @Param("search")String search);

	int count(@Param("select")String select, @Param("search")String search);

	String printPage(@Param("url")String url, @Param("currentPage")int currentPage, 
			@Param("totalCount")int totalCount, @Param("pageBlock")int pageBlock);

	 List<photoDTO> homePhoto() ;
	
	 List<BoardDTO> mainhomeboard(@Param("begin")int begin, @Param("end")int end) ;

	
}
