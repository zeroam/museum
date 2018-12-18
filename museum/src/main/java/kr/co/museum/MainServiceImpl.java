package kr.co.museum;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.museum.board.news.NewsVO;
import kr.co.museum.utils.FileVO;

@Service
public class MainServiceImpl implements MainService {
	@Inject
	MainDAO dao;

	@Override
	public FileVO select_file(Map<String, String> map) {
		return dao.select_file(map);
	}

	@Override
	public List<NewsVO> get_news() {
		return dao.get_news();
	}

	@Override
	public NewsVO get_event() {
		return dao.get_event();
	}

}
