package com.care.dbQuiz.board;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardMapper {

	ArrayList<BoardDTO> boardForm(@Param("begin")int begin, @Param("end")int end);

	int count();

	void boardWriteService(BoardDTO board);

	BoardDTO selectNo(int no);

	void hits(int no);

	String boardDownload(int no);

	void modify(BoardDTO board);

	void delete(int no);

}
