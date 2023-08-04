package com.care.project.board;

/*
 CREATE TABLE project_board(
id VARCHAR2(21),
no number,
title VARCHAR2(300),
content VARCHAR2(2000),
file_name VARCHAR2(255),
write_date VARCHAR2(15),
hits number,
likes number,
primary key(no)
);
commit; 
 */

public class BoardDTO {
	private int no;
	private String id;
	private String category;
	private String title;
	private String content;
	private String fileName;
	private String writeDate;
	private int hits;
    private int likes;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}	
	
}
