package kr.co.museum;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.museum.board.news.NewsVO;
import kr.co.museum.utils.FileVO;

@Repository
public class MainDAO {
	@Inject
	SqlSessionTemplate mybatis;
	
	public FileVO select_file(Map<String, String> map) {
		return mybatis.selectOne("file_sql.SELECT_FILE", map);
	}
	
	// ajax 관련 메서드
	public List<NewsVO> get_news() {
		return mybatis.selectList("board_sql.SELECT_LATEST_NEWS");
	}
	public NewsVO get_event() {
		return mybatis.selectOne("board_sql.SELECT_ONE_EVENT");
	}
}
