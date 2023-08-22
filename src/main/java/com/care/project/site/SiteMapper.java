package com.care.project.site;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SiteMapper {

	String siteInfo(String category);

	void siteUpdate(@Param("category")String category, @Param("content")String content);

}
