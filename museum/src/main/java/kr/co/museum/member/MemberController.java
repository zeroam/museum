package kr.co.museum.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	@Inject
	MemberService service;

	// 로그인 페이지
	@RequestMapping(value="/login")
	public String login() {
		return "/content/member/login";
	}
	// 로그인
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(MemberVO vo, HttpSession session, Model model) {
		MemberVO member = service.login(vo);
		// 잘못된 정보 입력시
		if(member == null) {
			model.addAttribute("login", false);
			return "/content/member/login";
		} else {
			session.setAttribute("member", member);
			return "redirect:/";
		}
	}
	
	// 로그아웃
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
