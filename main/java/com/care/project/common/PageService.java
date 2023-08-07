package com.care.project.common;

public class PageService {
	public static String printPage(String url, int currentPage, int totalCount, int pageBlock) {
		String result = "";
		if(currentPage <= 1){
			result += "<a href='" + url + "1'> < </a>";
		}else{
			result += "<a href='"+ url + (currentPage-1)+"'> < </a>";
		}
	
		int totalPage = totalCount / pageBlock;
		if(totalCount % pageBlock != 0)
			totalPage++;
		
		if(totalPage == 0) {
			result += "<a href='"+ url+"<b>"+1+"</b>"+"'>"+1+"</a>";	
		}else {
			for(int i = 1; i <= totalPage; i++){
				result +="<a href='"+ url+i+"'>"+i+" </a>";	
			}
		}
		
		if(currentPage >= totalPage){
			result +="<a href='"+url+totalPage+"'> > </a>";
		}else{
			result +="<a href='"+url + (currentPage+1)+"'> > </a>";
		}
		
		return result;
	}
}
