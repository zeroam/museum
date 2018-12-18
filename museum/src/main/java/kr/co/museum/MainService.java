package kr.co.museum;


import java.util.List;
import java.util.Map;

import kr.co.museum.board.news.NewsVO;
import kr.co.museum.utils.FileVO;

public interface MainService {
	// 파일 관련 메서드
	public FileVO select_file(Map<String, String> map);
	
	
	// ajax 관련 메서드
	public List<NewsVO> get_news();
	public NewsVO get_event();
}
