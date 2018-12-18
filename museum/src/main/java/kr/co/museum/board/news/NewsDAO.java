package kr.co.museum.board.news;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.museum.utils.FileVO;
import kr.co.museum.utils.PageMapper;

@Repository
public class NewsDAO {
	@Inject
	SqlSessionTemplate mybatis;

	// news 관련 메서드
	public int news_total() {
		return mybatis.selectOne("board_sql.SELECT_TOTAL_NEWS");
	}

	public List<NewsVO> news_list(PageMapper mapper) {
		return mybatis.selectList("board_sql.SELECT_NEWS", mapper);
	}

	public NewsVO news_view(String seq) {
		return mybatis.selectOne("board_sql.SELECT_ONE_NEWS", seq);
	}

	public int news_write(NewsVO vo) {
		mybatis.insert("board_sql.INSERT_NEWS", vo);
		return vo.getSeq();
	}

	public void news_update_hit(String seq) {
		mybatis.update("board_sql.UPDATE_NEWS_HIT", seq);
	}

	public void news_delete(String seq) {
		mybatis.delete("board_sql.DELETE_NEWS", seq);
	}

	public void news_update(NewsVO vo) {
		mybatis.update("board_sql.UPDATE_NEWS", vo);
	}
	
	// event 관련 메서드
	public int event_total() {
		return mybatis.selectOne("board_sql.SELECT_TOTAL_EVENT");
	}
	
	public List<NewsVO> event_list(PageMapper mapper) {
		return mybatis.selectList("board_sql.SELECT_EVENT", mapper);
	}

	// 이전 이후 글
	public NewsVO news_prev(Map<String, String> map) {
		return mybatis.selectOne("board_sql.SELECT_NEWS_PREV", map);
	}

	public NewsVO news_next(Map<String, String> map) {
		return mybatis.selectOne("board_sql.SELECT_NEWS_NEXT", map);
	}

	// tb_file 관련 메서드
	public void file_insert(FileVO fvo) {
		mybatis.insert("file_sql.INSERT_TB_FILE", fvo);
	}

	public FileVO file_select(Map<String, String> map) {
		return mybatis.selectOne("file_sql.SELECT_FILE", map);
	}

	public void file_delete(FileVO fvo) {
		mybatis.delete("file_sql.DELETE_FILE", fvo);
	}
}
