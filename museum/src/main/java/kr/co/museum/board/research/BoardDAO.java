package kr.co.museum.board.research;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.museum.utils.FileVO;
import kr.co.museum.utils.PageMapper;

@Repository
public class BoardDAO {
	@Inject
	SqlSessionTemplate mybatis;

	// board_normal 관련 메서드
	public List<BoardVO> normal_list(PageMapper mapper) {
		return mybatis.selectList("board_sql.SELECT_BOARD_NORMAL", mapper);
	}

	public void normal_update(BoardVO vo) {
		mybatis.update("board_sql.UPDATE_BOARD_NORMAL", vo);
	}

	public BoardVO normal_view(String seq) {
		return mybatis.selectOne("board_sql.SELECT_ONE_BOARD_NORMAL", seq);
	}
	
	public int normal_write(BoardVO vo) {
		mybatis.insert("board_sql.INSERT_BOARD_NORMAL", vo);
		return vo.getSeq(); 
	}
	
	public void normal_delete(String seq) {
		mybatis.delete("board_sql.DELETE_BOARD_NORMAL", seq);
	}
	
	public int total_board_dona() {
		return mybatis.selectOne("board_sql.TOTAL_BOARD_DONA");
	}
	
	// tb_file 관련 메서드
	public void file_insert(FileVO fvo) {
		mybatis.insert("file_sql.INSERT_TB_FILE", fvo);
	}
	
	public FileVO file_select(String seq) {
		return mybatis.selectOne("file_sql.SELECT_TB_FILE", seq);
	}
	
	public void file_delete(FileVO fvo) {
		mybatis.delete("file_sql.DELETE_TB_FILE", fvo);
	}
	
	// donationlist 관련 메서드
	public List<BoardVO> donation_search(PageMapper mapper) {
		return mybatis.selectList("board_sql.DONATION_SEARCH", mapper);
	}
	

	// collectionlist 관련 메서드
	public List<BoardVO> collection_list(PageMapper mapper) {
		return mybatis.selectList("board_sql.SELECT_COLLECTION_LIST", mapper);
	}
	
	public int total_collection_list() {
		return mybatis.selectOne("board_sql.TOTAL_COLLECTION_LIST");
	}
	
	public void collection_update(BoardVO vo) {
		mybatis.update("board_sql.UPDATE_COLLECTION_LIST", vo);
	}
}
