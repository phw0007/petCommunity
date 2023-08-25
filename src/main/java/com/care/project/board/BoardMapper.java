package com.care.project.board;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BoardMapper {
	ArrayList<BoardDTO> boardForm(@Param("begin")int begin, @Param("end")int end);
	ArrayList<BoardDTO> freeboardForm(@Param("begin")int begin, @Param("end")int end);
	ArrayList<BoardDTO> qNaboardForm(@Param("begin")int begin, @Param("end")int end);
	ArrayList<BoardDTO> dogboardForm(@Param("begin")int begin, @Param("end")int end);
	ArrayList<BoardDTO> catboardForm(@Param("begin")int begin, @Param("end")int end);
	ArrayList<BoardDTO> reptileboardForm(@Param("begin")int begin, @Param("end")int end);
	ArrayList<BoardDTO> birdboardForm(@Param("begin")int begin, @Param("end")int end);
	ArrayList<BoardDTO> fishboardForm(@Param("begin")int begin, @Param("end")int end);
	ArrayList<BoardDTO> smallboardForm(@Param("begin")int begin, @Param("end")int end);
	ArrayList<BoardDTO> etcboardForm(@Param("begin")int begin, @Param("end")int end);
	//count();
	int freecount();
	int qNacount();
	int dogcount();
	int catcount();
	int reptilecount();
	int birdcount();
	int fishcount();
	int smallcount();
	int etccount();
	
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
	void boardLike(@Param("id") String id, @Param("category") String category, @Param("no") int no);
	BoardDTO boardLikeCheck(@Param("id") String id, @Param("category") String category, @Param("no") int no,
			String likesId);
	void boardHitDown(@Param("id") String id, @Param("category") String category, @Param("no") int no);
	void boardLikeUserInsert(@Param("id") String id, @Param("category") String category, @Param("no") int no,
			String likesId);
	   /*board검색부분*/
	ArrayList<BoardDTO> boardSearch(@Param("begin")int begin, @Param("end")int end, 
			@Param("select")String select, @Param("search")String search,@Param("category")String category);
	int searchCount(@Param("select")String select, @Param("search")String search);
	
	


}