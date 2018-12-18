package kr.co.museum.board.research;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.museum.utils.FileVO;
import kr.co.museum.utils.PageMapper;

public interface BoardService {
	
	// admin 인증 메서드
	public boolean authAdmin(HttpSession session);

	// board_normal 관련 메서드
	public List<BoardVO> normal_list(PageMapper mapper);
	public void normal_update(BoardVO vo);
	public int normal_write(BoardVO vo);
	public void normal_delete(String seq);
	public BoardVO normal_view(String seq);
	public int total_board_dona();
	
	// tb_file 관련 메서드
	public void file_insert(FileVO fvo);
	public FileVO file_select(String seq);
	public void file_delete(FileVO fvo);
	
	// donationlist 관련 메서드
	public List<BoardVO> donation_search(PageMapper mapper);
	
	// collectionlist 관련 메서드
	public List<BoardVO> collection_list(PageMapper mapper);
	public int total_collection_list();
	public void collection_update(BoardVO vo);

}
