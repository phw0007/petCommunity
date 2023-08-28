package com.care.project.info;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.care.project.ainfo.AInfoDTO;

@Mapper
public interface InfoMapper {

   ArrayList<InfoDTO> InfoData(@Param("begin")int begin, @Param("end")int end, 
         @Param("select")String select, @Param("search")String search,@Param("category")String category);

   int hoscount(@Param("select")String select, @Param("search")String search);

   ArrayList<InfoDTO> minfoCheck();
   int hosinfoCheck(@Param("category")String category);

   void insertInfo(@Param("subjectCategory")String subjectCategory, 
         @Param("title")String title, @Param("venue")String venue, 
         @Param("reference")String reference, @Param("source")String source);
     /*info검색부분 */
   ArrayList<InfoDTO> infoSearch(@Param("begin")int begin, @Param("end")int end, 
         @Param("select")String select, @Param("search")String search,@Param("category")String category);
   int infoSearchCount(@Param("select")String select, @Param("search")String search);

}