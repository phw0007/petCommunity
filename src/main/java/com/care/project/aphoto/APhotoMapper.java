package com.care.project.aphoto;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface APhotoMapper {

	ArrayList<APhotoDTO> photoData(@Param("begin")int begin, @Param("end")int end,
			@Param("select")String select, @Param("search")String search);

	int count(@Param("select")String select, @Param("search")String search);

	void aphotoHit(@Param("id")String id, @Param("category")String category, @Param("no")int no);

	APhotoDTO aphotoInfo(@Param("id")String id, @Param("category")String category, @Param("no")int no);

	ArrayList<APhotoDTO> aphotoComment(@Param("id")String id, @Param("category")String category, @Param("no")int no);

	void aphotoDelete(@Param("id")String id, @Param("category")String category, @Param("no")int no);

	void aphotoCommentDelete(@Param("id")String id, @Param("category")String category, @Param("no")int no);

	void aphotoNoUpdate(int no);

	void aphotoCommentNoUpdate(int no);

	void commentDeleteButton(@Param("id")String id, @Param("category")String category, 
			@Param("no")int no, @Param("writeDate")String writeDate);

}
