package com.care.project.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KakaoController {

    @Autowired
    private KakaoService kakaoService;

    @GetMapping("kakaoLogin")
    public String kakaoLogin(String code, Model model) {
        // KakaoService를 통해 액세스 토큰 및 사용자 정보 가져오기
        kakaoService.getAccessToken(code);
        kakaoService.getUserInfo();

        // KakaoService에서 가져온 사용자 정보를 서비스 내부에서 저장
        kakaoService.setKakaoUserInfo(kakaoService.getKakaoUserInfo());

        // 회원가입 페이지로 이동
        return "/kakaoRegister.jsp"; // signup.html (또는 .jsp) 파일의 경로를 지정
    }
}