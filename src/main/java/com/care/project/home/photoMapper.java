package com.care.project.home;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface photoMapper {

	void photoWriteProc(photoDTO photo);

	photoDTO photoContent(int no);

	void incHit(int no);

	List<photoDTO> getAllPhotos();

	List<Image> getAllImages();

	ArrayList<photoDTO> photoData(int begin, int end, String select, String search);

	int count(String select, String search);

	String printPage(String url, int currentPage, int totalCount, int pageBlock);

	
}
