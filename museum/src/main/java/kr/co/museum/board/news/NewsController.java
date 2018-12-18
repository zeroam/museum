package kr.co.museum.board.news;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.co.museum.utils.Config;
import kr.co.museum.utils.FileVO;
import kr.co.museum.utils.PageMapper;

@Controller
public class NewsController {
	@Inject
	NewsService service;

	private Map<String, String> newsMap = new HashMap<String, String>();
	private Map<String, String> eventMap = new HashMap<String, String>();

	public NewsController() {
		// news
		newsMap.put("content", "news");
		newsMap.put("index", "0");
		newsMap.put("cate", "news");
		// event
		eventMap.put("content", "news");
		eventMap.put("index", "0");
		eventMap.put("cate", "event");
	}

	// 새 소식 : 리스트 페이지
	@RequestMapping(value = "/news")
	public String news(Model model, PageMapper mapper) {
		// 리스트 창 활성화
		model.addAllAttributes(newsMap);

		List<NewsVO> voList = service.news_list(mapper);
		model.addAttribute("mapper", mapper);
		model.addAttribute("voList", voList);

		return "/content/news/news";
	}

	// 새 소식 : 뷰페이지
	@RequestMapping(value = "/news_view")
	public String newsView(Model model, String seq) {
		// 리스트창 활성화
		model.addAllAttributes(newsMap);

		// 글 정보
		NewsVO vo = service.news_view(seq);
		model.addAttribute("vo", vo);

		// 이전글, 이후글
		String cate = "news";
		NewsVO preVO = service.news_prev(cate, seq);
		NewsVO nextVO = service.news_next(cate, seq);
		model.addAttribute("preVO", preVO);
		model.addAttribute("nextVO", nextVO);

		return "/content/news/news_view";
	}

	// 새 소식 : 글쓰기 페이지
	@RequestMapping(value = "/news_write")
	public String newsWrite(Model model, HttpSession session) {
		// admin 인증
		if (Config.authAdmin(session)) {
			// 리스트창 활성화
			model.addAllAttributes(newsMap);

			return "/content/news/news_write";
		} else {
			return "redirect:/";
		}
	}

	// 새 소식 : 글쓰기
	@RequestMapping(value = "/news_write", method = RequestMethod.POST)
	public String newsWrite(HttpSession session, MultipartFile fname, NewsVO vo) throws Exception {
		// admin 인증
		if (Config.authAdmin(session)) {
			service.news_write(vo, fname, session);
			return "redirect:/news";
		} else {
			return "redirect:/";
		}
	}

	// 새 소식 : 글 수정 페이지
	@RequestMapping(value = "/news_update")
	public String newsUpdate(Model model, HttpSession session, String seq) {
		// admin 인증
		if (Config.authAdmin(session)) {
			NewsVO vo = service.news_select(seq);
			model.addAttribute("vo", vo);
			return "/content/news/news_update";
		} else {
			return "redirect:/";
		}
	}

	// 새 소식 : 글 수정
	@RequestMapping(value = "/news_update", method = RequestMethod.POST)
	public String newsUpdate(HttpSession session, NewsVO vo) {
		if (Config.authAdmin(session)) {
			service.news_update(vo);
		}

		return "redirect:/news";
	}

	// 새 소식 : 글삭제
	@RequestMapping(value = "/news_delete")
	public String newsDelete(HttpSession session, String seq, String cate) {
		// admin 인증
		if (Config.authAdmin(session)) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("seq", seq);
			map.put("cate", cate);

			service.news_delete(map, session);
			return "redirect:/"+cate;
		} else {
			return "redirect:/";
		}
	}

	// 문화행사 : 리스트페이지
	@RequestMapping(value = "/event")
	public String event(Model model, PageMapper mapper) {
		// 리스트 창 활성화
		model.addAllAttributes(eventMap);

		List<NewsVO> voList = service.event_list(mapper);
		model.addAttribute("mapper", mapper);
		model.addAttribute("voList", voList);

		return "/content/news/event";
	}

	// 문화행사 : 뷰페이지
	@RequestMapping(value = "/event_view")
	public String eventView(Model model, String seq) {
		// 리스트창 활성화
		model.addAllAttributes(eventMap);

		// 글 정보
		NewsVO vo = service.news_view(seq);
		model.addAttribute("vo", vo);

		// 이전글, 이후글
		String cate = "event";
		NewsVO preVO = service.news_prev(cate, seq);
		NewsVO nextVO = service.news_next(cate, seq);
		model.addAttribute("preVO", preVO);
		model.addAttribute("nextVO", nextVO);

		return "/content/news/event_view";
	}

	// 문화행사 : 글쓰기 페이지
	@RequestMapping(value = "/event_write")
	public String eventWrite(Model model, HttpSession session) {
		// admin 인증
		if (Config.authAdmin(session)) {
			// 리스트창 활성화
			model.addAllAttributes(eventMap);

			return "/content/news/event_write";
		} else {
			return "redirect:/";
		}
	}

	// 문화행사 : 글쓰기
	@RequestMapping(value = "/event_write", method = RequestMethod.POST)
	public String eventWrite(HttpSession session, MultipartFile fname, NewsVO vo) throws Exception {
		// admin 인증
		if (Config.authAdmin(session)) {
			service.news_write(vo, fname, session);
			return "redirect:/event";
		} else {
			return "redirect:/";
		}
	}
}
