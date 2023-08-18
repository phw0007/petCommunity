package com.care.project.member;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class KakaoService {
	private String accessToken;
	private String scope;
	
	
	public void getAccessToken(String code) {
		/*
		 * 액세스 토큰 가져오기
		 * https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#request-token
		 * https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#request-code-info
		 */
		String redirectUri = "http://localhost/kakaoLogin";
		String reqUrl = "https://kauth.kakao.com/oauth/token";
		String reqParam = "grant_type=authorization_code";
		reqParam += "&client_id=5fb646c4e122b6bf77a3b660ed215c0d";
		reqParam += "&redirect_uri="+redirectUri;
		reqParam += "&code=" + code;

		HttpURLConnection conn;
		try {
			URL url = new URL(reqUrl); // POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST"); // POST 요청을 위해 기본값 false에서 setDoOutput을 true로 변경
			conn.setDoOutput(true); // POST 메소드를 이용해서 데이터를 전달하기 위한 설정

			// 기본 outputStream을 통해 문자열로 처리할 수 있는 OutPutStreamWriter 변환 후 처리속도를 빠르게 하기 위한
			// BufferedWrtier로 변환해서 사용한다.(OutPutStreamWriter로만도 사용 가능하긴 한데 속도를 위해!)
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			bw.write(reqParam);
			bw.flush(); // 작업이 끝나면 저장 공간을 비우겠다!

			int responseCode = conn.getResponseCode(); // 결과 코드가 200이라면 성공
//			System.out.println("responseCode : " + responseCode);

			// 요청을 통해 얻은 JSON 타입의 Response 메세지 읽어오기
			InputStreamReader isr = new InputStreamReader(conn.getInputStream()); // conn.getInputStream은 html에서 지원안해서
			ObjectMapper om = new ObjectMapper();
			Map<String, String> map = null; // 자료형에 이렇게 제너릭이 붙어있어버려서 typereference쓴거임(제너릭이 없으면 자로형.class로만 써도 됨)
			map = om.readValue(isr, new TypeReference<Map<String, String>>() {
			});
			accessToken = map.get("access_token");

			System.out.println("accsess_token : " + map.get("access_token"));
			System.out.println("scope : " + map.get("scope"));

			/*
			 * response body :
			 * {"access_token":"zz2WgskSIwfnoPzm5L10yDs-34EBMV_PGqDenAGZCj102gAAAYlm53u7",
			 * "token_type":"bearer",
			 * "refresh_token":"R9hm3A2B2MjjALYHtkIAFs_pPAJuDoVunaZ6c29-Cj102gAAAYlm53u6",
			 * "expires_in":21599, "scope":"account_email profile",
			 * "refresh_token_expires_in": 5183999 }
			 */
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void setNeedsAgreement() {
	/*
	 * # 추가 항목 동의 받기 #
	 * https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#request-code-additional-consent
	 */
	//https://kauth.kakao.com/oauth/authorize?client_id=${REST_API_KEY}&redirect_uri=${REDIRECT_URI}&response_type=code&scope=account_email,gender	

		String redirectUri = "http://localhost/kakaoLogin";
		String reqUrl = "https://kauth.kakao.com/oauth/authorize";
		String reqParam = "?client_id=5fb646c4e122b6bf77a3b660ed215c0d";
		reqParam += "&redirect_uri=" + redirectUri;
		reqParam += "&response_type=code&scope="+scope;
		
		HttpURLConnection conn;
		try {
			URL url = new URL(reqUrl); // POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			bw.write(reqParam);
			bw.flush();

			int responseCode = conn.getResponseCode(); // 결과 코드가 200이라면 성공
			System.out.println("responseCode : " + responseCode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void getUserInfo() {
		/*
		 * 사용자 정보 가져오기
		 * https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#req-user-info
		 */
		
		String reqUrl = "https://kapi.kakao.com/v2/user/me";
		
		HttpURLConnection conn;
		try {
			URL url = new URL(reqUrl); 
			conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", "Bearer " + accessToken); //Authorization: Bearer ${ACCESS_TOKEN}

			int responseCode = conn.getResponseCode(); //결과 코드가 200이라면 성공
//			System.out.println("responseCode : " + responseCode);
			
			ObjectMapper om = new ObjectMapper();
			JsonNode jsonTree = om.readTree(conn.getInputStream());
			
			System.out.println("jsonTree : " + jsonTree);
			System.out.println("kakao_account : " + jsonTree.get("kakao_account"));
			
			JsonNode kakaoAccount = jsonTree.get("kakao_account");
			System.out.println("profile : " + kakaoAccount.get("profile"));
			System.out.println("email : " + kakaoAccount.get("email"));
			System.out.println("age_range : " + kakaoAccount.get("age_range"));
			System.out.println("gender : " + kakaoAccount.get("gender"));

			System.out.println("profile : " + kakaoAccount.get("profile"));
			System.out.println("nickname : " + kakaoAccount.get("profile").get("nickname"));
			System.out.println(kakaoAccount.get("profile").get("nickname").textValue());
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	

    private Map<String, String> kakaoUserInfo = new HashMap<>();

    public Map<String, String> getKakaoUserInfo() {
        return kakaoUserInfo;
    }

    public void setKakaoUserInfo(Map<String, String> userInfo) {
        this.kakaoUserInfo = userInfo;
    }
    
	
	public void unLink() {
		/*
		 * 연결 끊기
		 * https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#unlink
		 * */
		
		String reqUrl = "https://kapi.kakao.com/v1/user/unlink";
		
		HttpURLConnection conn;
		try {
			URL url = new URL(reqUrl); 
			conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", "Bearer " + accessToken); //Authorization: Bearer ${ACCESS_TOKEN}

			int responseCode = conn.getResponseCode(); //결과 코드가 200이라면 성공
			System.out.println("responseCode : " + responseCode);
			
			ObjectMapper om = new ObjectMapper();
			JsonNode jsonTree = om.readTree(conn.getInputStream());
			
			System.out.println("jsonTree : " + jsonTree);
			System.out.println("id : " + jsonTree.get("id"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}

