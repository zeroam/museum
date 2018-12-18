package kr.co.museum.board.research;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import kr.co.museum.member.MemberVO;
import kr.co.museum.utils.FileVO;
import kr.co.museum.utils.PageMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	BoardDAO dao;

	// Admin 인증 서비스
	@Override
	public boolean authAdmin(HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("member");
		// admin 계정인 경우
		if (member != null && member.getUser().equals("admin")) {
			return true;
		}
		return false;
	}
	
	// board_normal 관련 메서드
	@Override
	public List<BoardVO> normal_list(PageMapper mapper) {
		return dao.normal_list(mapper);
	}

	@Override
	public void normal_update(BoardVO vo) {
		dao.normal_update(vo);
	}

	@Override
	public BoardVO normal_view(String seq) {
		return dao.normal_view(seq);
	}

	@Override
	public int normal_write(BoardVO vo) {
		return dao.normal_write(vo);
	}

	@Override
	public void normal_delete(String seq) {
		dao.normal_delete(seq);
	}
	
	// tb_file 관련 메서드
	@Override
	public void file_insert(FileVO vo) {
		dao.file_insert(vo);
	}

	@Override
	public FileVO file_select(String seq) {
		return dao.file_select(seq);
	}
	
	public void file_delete(FileVO fvo) {
		dao.file_delete(fvo);
	}

	// 페이지 관련 메서드
	@Override
	public int total_board_dona() {
		return dao.total_board_dona();
	}
	
	// donationlist 관련 메서드
	@Override
	public List<BoardVO> donation_search(PageMapper mapper) {
		return dao.donation_search(mapper);
	}
	

	// collectionlist 관련 메서드
	@Override
	public List<BoardVO> collection_list(PageMapper mapper) {
		return dao.collection_list(mapper);
	}

	@Override
	public int total_collection_list() {
		return dao.total_collection_list();
	}

	@Override
	public void collection_update(BoardVO vo) {
		dao.collection_update(vo);
		
	}

}
