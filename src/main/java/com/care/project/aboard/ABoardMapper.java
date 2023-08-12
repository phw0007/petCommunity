package com.care.project.aboard;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ABoardMapper {
	int count(@Param("select")String select, @Param("search")String search);

	ABoardDTO aboardInfo(@Param("id")String id, @Param("category")String category,
			@Param("no")int no);

	ArrayList<ABoardDTO> boardData(@Param("begin")int begin, @Param("end")int end, 
			@Param("select")String select, @Param("search")String search);

	ArrayList<ABoardDTO> aboardComment(@Param("id")String id, @Param("category")String category, 
			@Param("no")int no);

	void boardDelete(String name);

	void aboardDelete(@Param("id")String id, @Param("category")String category, @Param("no")int no);

	void aboardCommentDelete(@Param("id")String id, @Param("category")String category, @Param("no")int no);

	void aboardNoUpdate(int no);

	void aboardCommentNoUpdate(int no);

	void commentDeleteButton(@Param("id")String id, @Param("category")String category, 
			@Param("no")int no, @Param("writeDate")String writeDate);

	ArrayList<ABoardDTO> boardAnnoData(@Param("begin")int begin, @Param("end")int end, 
			@Param("select")String select, @Param("search")String search);

	int annoCount(@Param("select")String select, @Param("search")String search);

	void aboardAnnoRegister(ABoardDTO aboardDto);

	void aboardAnnoUpdate(ABoardDTO aboardDto);
}
