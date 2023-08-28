package com.care.project.info;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.care.project.ainfo.AInfoDTO;
import com.care.project.board.BoardDTO;
import com.care.project.common.PageService;

import jakarta.servlet.http.HttpSession;

@Service
public class InfoService {
    @Autowired InfoMapper infoMapper;
    @Autowired HttpSession session;
    
	public void info(String cp, String select, String search, Model model,String category,String jsp) {
		if(select == null){
			select = "";
		}
		
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(cp);
		}catch(Exception e){
			currentPage = 1;
		}
			
		if(search == null) {
			search = "";
		}
	
		int pageBlock = 10; 
		int end = pageBlock * currentPage; 
		
		int begin = end - pageBlock + 1; 
		int no = 0;
		ArrayList<InfoDTO> info = infoMapper.InfoData(begin, end, select, search,category);
	    int totalCount=infoMapper.hosinfoCheck(category);
		System.out.println("여기서도 나오나?"+category);
		//int totalCount = infoMapper.hoscount(select, search);
		String url =jsp+"?select="+select+"&search="+search+"&category="+category+"&currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		no = (currentPage-1)*10;
		model.addAttribute("info", info);
		model.addAttribute("result", result);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("no", no);
		model.addAttribute("select", select);
		model.addAttribute("search", search);
	}

	
	
	public void xmlInsert() {
		String[] keywordList = {"동물병원", "동물약국", "학교체육시설", "수영장", "축구장"}; 
		ArrayList<InfoDTO> infoList = infoMapper.minfoCheck();
		if(infoList.isEmpty() == false) {
			return;
		}else {
			for(String keyword : keywordList) {
				try {
					StringBuilder urlBuilder = new StringBuilder("http://api.kcisa.kr/openapi/service/rest/convergence2019/getConver03"); /*URL*/
					urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=d3bda547-569e-4b05-bc18-08fa43ce9511"); /*서비스키*/
					urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("30", "UTF-8")); /*세션당 요청레코드수*/
					urlBuilder.append("&" + URLEncoder.encode("keyword","UTF-8") + "=" + URLEncoder.encode(keyword, "UTF-8"));
					
					URL url = new URL(urlBuilder.toString());
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
					conn.setRequestMethod("GET");
					conn.setRequestProperty("Content-type", "application/xml");
					System.out.println("Response code: " + conn.getResponseCode());
			
					BufferedReader rd;
					if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
						rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					} else {
						rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
					}
					StringBuilder sb = new StringBuilder();
					String line;
					while ((line = rd.readLine()) != null) {
						sb.append(line);
					}
					rd.close();
					conn.disconnect();
					String xmlResponse = sb.toString();
					System.out.println(sb.toString());
		            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		            InputSource inputSource = new InputSource(new StringReader(xmlResponse));
		            Document doc = dBuilder.parse(inputSource);
		            
		            doc.getDocumentElement().normalize();
		            
		            NodeList rowList = doc.getElementsByTagName("item");
		            for (int i = 0; i < rowList.getLength(); i++) {
		                Node rowNode = rowList.item(i);
		                if (rowNode.getNodeType() == Node.ELEMENT_NODE) {
		                    Element rowElement = (Element) rowNode;
		                    
		                    String subjectCategory = rowElement.getElementsByTagName("subjectCategory").item(0).getTextContent();
		                    String title = rowElement.getElementsByTagName("title").item(0).getTextContent();
		                    String venue = rowElement.getElementsByTagName("venue").item(0).getTextContent();
		                    String reference = rowElement.getElementsByTagName("reference").item(0).getTextContent();
		                    String source = rowElement.getElementsByTagName("source").item(0).getTextContent();
		                    String state = rowElement.getElementsByTagName("state").item(0).getTextContent();
		  
		                    if(state.equals("정상")){
			                    System.out.println("업체분류: " + subjectCategory);
			                    System.out.println("사업장명: " + title);
			                    System.out.println("주소: " + venue);
			                    System.out.println("전화번호: " + reference);
			                    System.out.println("홈페이지: " + source);
			                    System.out.println("상태: " + state);
			                    infoMapper.insertInfo(subjectCategory, title, venue, reference, source);
		                    }else if(state.equals("실내") || state.equals("실외")) {
		                    	System.out.println("업체분류: " + subjectCategory);
		  	                    System.out.println("사업장명: " + title);
		  	                    System.out.println("주소: " + venue);
		  	                    System.out.println("전화번호: " + reference);
		  	                    System.out.println("홈페이지: " + source);
		  	                    System.out.println("상태: " + state);
		  	                    infoMapper.insertInfo(subjectCategory, title, venue, reference, source);
		                    }
		                }
		            }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
		}
	}


	

}