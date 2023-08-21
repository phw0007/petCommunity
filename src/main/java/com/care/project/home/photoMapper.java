package com.care.project.home;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface photoMapper {

	void photoWriteProc(photoDTO photo);

	photoDTO photoContent(int no);

	void incHit(int no);

}
