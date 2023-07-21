package com.care.ajaxBasic;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MemberService {
	@Autowired private  MemberMapper mapper;
	
	public String exists(String id) {
		if(id == null || id.isEmpty())
			return "아이디를 입력하세요.";
		
		Pattern pattern = Pattern.compile("^[a-z0-9]{1}[a-z0-9_-]{4,19}$");
		Matcher matcher = pattern.matcher(id);
		if(matcher.matches() == false)
			return "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.";
		
		String result = mapper.exists(id);
		if(result == null)
			return "사용 가능한 아이디 입니다.";
		return "사용 할 수 없는 아이디입니다. 다른 아이디를 입력해 주세요.";
	}

	public String jsonInsert() {
		/*
		 * JSON 파일의 데이터를 읽어와서 
		 * mapper.jsonInsert()를 호출해서 
		 * json_table 이름의 테이블에 jsonExam2.json 파일의 데이터를 입력
		 * json_table 테이블의 컬럼은 title, artist, price varchar2로 구성.
		 * 확인 : sqlDeveloper에서 직접 확인(SELECT * FROM json_table;)
		 */
		ClassPathResource cpr = new ClassPathResource("jsonExam2.json");
		List<AjaxVo> lists = null;
		try {
			File file = cpr.getFile();
			ObjectMapper mapper = new ObjectMapper();
			lists = mapper.readValue(file, new TypeReference<List<AjaxVo>>() {});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * 테이블 생성
		 CREATE TABLE json_table (
		    title varchar2(20),
		    artist varchar2(20),
		    price varchar2(10)
		);
		COMMIT;
		*/
		
		//json_table 테이블의 모든 데이터 삭제, 초기화 
		mapper.jsonDelete();
		
		for(AjaxVo ajax : lists) {
			int result = mapper.jsonInsert(ajax);
			if(result == 0)
				return "데이터 입력 중 오류가 발생했습니다. 다시 시도 하세요.";
		}
		
		return "모든 데이터가 입력되었습니다.";
	}

	public List<AjaxVo> ex6() {
		return mapper.ex6();
	}

	public List<AjaxVo> all() {
		return mapper.all();
	}
	public List<AjaxVo> title(String title) {
		return mapper.title(title);
	}
}







