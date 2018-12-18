package kr.co.museum.utils;

import javax.servlet.http.HttpSession;

import kr.co.museum.member.MemberVO;

public class Config {
	// 페이지당 글 수
	public static final int PAGE_NUM = 15;

	// Admin 인증 서비스
	public static boolean authAdmin(HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		// admin 계정인 경우
		if (member != null && member.getUser().equals("admin")) {
			return true;
		}
		return false;
	}
}
