package com.care.project.board;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BoardMapper {
	ArrayList<BoardDTO> boardForm(@Param("begin")int begin, @Param("end")int end);
	ArrayList<BoardDTO> freeboardForm(@Param("begin")int begin, @Param("end")int end);
	int count();
	int freecount();
	void boardWriteProc(BoardDTO board);
	BoardDTO boardContent(int no);
	void incHit(int no);
	void likes(int like);
	String boardDownload(int no);
	void boardModifyProc(BoardDTO board);
	void boardDeleteProc(int no);
	void freecommentProc(BoardDTO board);
	ArrayList<BoardDTO> freeComment(int no,String category);
	void commentDeleteProc(@Param("id")String id, @Param("category")String category, 
			@Param("no")int no, @Param("writeDate")String writeDate);
}