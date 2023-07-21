package com.care.ajaxBasic;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapper {

	String exists(String id);

	int jsonInsert(AjaxVo ajax);

	void jsonDelete();

	List<AjaxVo> ex6();

	List<AjaxVo> all();

	List<AjaxVo> title(String title);
}









