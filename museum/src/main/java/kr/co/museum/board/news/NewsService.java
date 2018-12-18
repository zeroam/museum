package kr.co.museum.board.news;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import kr.co.museum.utils.PageMapper;

public interface NewsService {
	// new 관련 메서드
	public List<NewsVO> news_list(PageMapper mapper);
	public NewsVO news_view(String seq);
	public NewsVO news_select(String seq);
	public void news_write(NewsVO vo, MultipartFile fname, HttpSession session) throws Exception;
	public void news_delete(Map<String, String> map, HttpSession session);
	public void news_update(NewsVO vo);
	
	// event 관련 메서드
	public List<NewsVO> event_list(PageMapper mapper);
	
	// 이전 이후 글
	public NewsVO news_prev(String cate, String seq);
	public NewsVO news_next(String cate, String seq);
}
