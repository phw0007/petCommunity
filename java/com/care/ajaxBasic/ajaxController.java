package com.care.ajaxBasic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty.Type;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ajaxController {

	@GetMapping("ex1")
	public void ex1Get() {
	}
	@PostMapping("ex1a")
	public void ex1PostA() {
		System.out.println("ajax 요청 도착");
	}
	
	@PostMapping("ex1b")
	public void ex1PostB(@RequestBody String ajaxParam) {
		System.out.println("ajax 요청 도착 : " + ajaxParam);
	}
	
	@ResponseBody
	@PostMapping(value="ex1c", produces = "text/plain; charset=UTF-8")
	public String ex1PostC(@RequestBody String ajaxParam) {
		System.out.println("ajax 요청 도착 : " + ajaxParam);
		return "응답 데이터";
	}
	
	@GetMapping("ex2")
	public void ex2Get() {}
	
	@Autowired private MemberService service;
	
	@ResponseBody
	@PostMapping(value="ex2", produces = "text/plain; charset=UTF-8")
	public String ex2Post(@RequestBody(required = false) String id) {
		//System.out.println("입력한 아이디 : " + id);
		return service.exists(id);
	}
	
	@GetMapping("ex3")
	public void ex3Get() {}
	
//	@PostMapping("ex3")
//	public void ex3Post(@RequestBody Map<String, String> reqData) {
//		System.out.println("reqData : " + reqData.get("id"));
//		System.out.println("reqData : " + reqData.get("pw"));
//	}
	
	@ResponseBody
	@PostMapping("ex3")
	public Map<String, String> ex3Post(@RequestBody AjaxDTO reqData) {
		System.out.println("reqData : " + reqData.getId());
		System.out.println("reqData : " + reqData.getPw());
		
		Map<String, String> resData = new HashMap<String, String>();
		resData.put("idPrint", "아이디는 서버에 저장되어 있어요");
		resData.put("pwPrint", "아이디/비밀번호를 확인 후 다시 입력하세요.");
		return resData;
	}
	
	@GetMapping("ex4")
	public void ex4Get() {}
	
	@ResponseBody
	@PostMapping(value="ex4", produces = "application/json; charset=UTF-8")
	public String ex4Post() {
		
		ClassPathResource cpr = new ClassPathResource("jsonExam.json");
		String result = "";
		try {
			File file = cpr.getFile();
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			while(true) {
				String tmp = br.readLine();
				if(tmp == null)
					break;
				result += tmp;
			}
			
			br.close();
			fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@GetMapping("ex5")
	public void ex5Get() {}
	
	@ResponseBody
	@PostMapping(value="ex5", produces = "application/json; charset=UTF-8")
	public List<AjaxVo> ex5Post() {
		
		ClassPathResource cpr = new ClassPathResource("jsonExam2.json");
		List<AjaxVo> lists = null;
		try {
			File file = cpr.getFile();
			
			// JSON Array -> List<AjaxVO> 변환
			ObjectMapper mapper = new ObjectMapper();
			lists = mapper.readValue(file, new TypeReference<List<AjaxVo>>() {});
			//mapper.readValue(JSON 데이터, 반환 자료형);
			
			System.out.println( (new TypeReference<List<AjaxVo>>() {}).getType() );
			//java.util.List<com.care.ajaxBasic.AjaxVO>
			//TypeReference를 사용하는 이유 : 제너릭을 사용하는 클래스의 자료형을 얻고 싶을 때
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lists;
	}
	
	
	
	/* 
	 * 한번만 수행 또는 데이터가 변경되었을 경우에만 수행함.
	 * JSON 파일의 데이터를 테이블에 모두 입력하는 기능
	 */
	@ResponseBody
	@GetMapping(value="jsonInsert", produces = "text/plain; charset=utf-8")
	public String jsonInsert() {
		String msg = service.jsonInsert();
		return msg;
	}
	
	/*
	 * ex5.jsp는 xxx.json 파일에서 데이터를 읽어서 클라이언트 화면에 출력함
	 * ex6.jsp는 json_table DB 데이터블에서 데이터를 읽어서 클라이언트 화면에 출력할 것
	 */
	@GetMapping("ex6")
	public void ex6Get() {}
	
	@ResponseBody
	@PostMapping(value="ex6", produces = "application/json; charset=UTF-8")
	public List<AjaxVo> ex6Post() {
		return service.ex6();
	}
	
	@GetMapping("quiz")
	public void quizGet() {}
	
	@ResponseBody
	@PostMapping(value="quiz", produces = "application/json; charset=UTF-8")
	public List<AjaxVo> quizPost(@RequestBody(required = false) String title) {
		/*
		 * 첫 화면 또는 input에 아무것도 입력이 안되어 있으면 모든 데이터 출력하기.
		 * input 에 입력한 글자를 포함한 데이터가 있으면 모두 출력하기.
		 */
		System.out.println("quizPost() 호출함.");
		if(title == null || title.isEmpty()) {
			return service.all();// 모든 데이터
		}
		
		return service.title(title);// 검색어에 맞는 결과
	}
}




















