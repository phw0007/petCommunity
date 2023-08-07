package com.care.project.aboard;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BoardMapper {
	int count(@Param("select")String select, @Param("search")String search);

	BoardDTO aboardInfo(@Param("id")String id, @Param("boardName")String boardName,
			@Param("no")int no);

	ArrayList<BoardDTO> boardData(@Param("begin")int begin, @Param("end")int end, 
			@Param("select")String select, @Param("search")String search);

	ArrayList<BoardDTO> aboardComment(@Param("id")String id, @Param("boardName")String boardName, 
			@Param("no")int no);
}