package kr.co.museum.board.news;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.museum.utils.FileUtil;
import kr.co.museum.utils.FileVO;
import kr.co.museum.utils.PageMapper;

@Service
public class NewsServiceImpl implements NewsService {
	@Inject
	NewsDAO dao;

	// news 관련 메서드
	// 전체 리스트 가져오기
	@Override
	public List<NewsVO> news_list(PageMapper mapper) {
		int total = dao.news_total();
		// mapper 객체 초기화
		mapper.setMapper(total);
		return dao.news_list(mapper);
	}
	// 뷰 페이지
	@Override
	public NewsVO news_view(String seq) {
		dao.news_update_hit(seq);
		return dao.news_view(seq);
	}
	
	@Override
	public void news_write(NewsVO vo, MultipartFile fname, HttpSession session) throws Exception {
		// 파일 업로드
		MultipartFile file = fname;
		// 파일이 첨부되었을 때
		if(!file.isEmpty()) {
			// 파일 저장 경로
			String target = FileUtil.getPath(session);
			
			String oName = file.getOriginalFilename();
			
			String ext = oName.substring(oName.lastIndexOf("."));
			String uName = UUID.randomUUID().toString() + ext;
			
			file.transferTo(new File(target + uName));
			
			// NewsVO에 이미지 경로, file 첨가여부 설정
			vo.setImg_src("/museum/data/"+uName);
			vo.setFile(1);
			
			// 데이터베이스 입력
			int seq = dao.news_write(vo);
			
			FileVO fvo = new FileVO();
			fvo.setBoard_cate(vo.getCate());
			fvo.setBoard_seq(seq);
			fvo.setOrigin_name(oName);
			fvo.setStored_name(uName);
			dao.file_insert(fvo);
		} else {
			// 데이터베이스 입력
			dao.news_write(vo);
		}
		
	}
	@Override
	public void news_delete(Map<String, String> map, HttpSession session) {
		// 파일 경로 찾기
		FileVO fvo = dao.file_select(map);
		// 파일 테이블이 존재할 때
		if(fvo != null) {
			String target = FileUtil.getPath(session);
			String fname = fvo.getStored_name();
			
			// 파일 삭제
			FileUtil.deleteFile(target + fname);
			
			// 파일 테이블 삭제
			dao.file_delete(fvo);
		}
		
		// 글 삭제
		dao.news_delete(map.get("seq"));
	}
	
	// seq로 NewsVO 객체 가져오기
	@Override
	public NewsVO news_select(String seq) {
		return dao.news_view(seq);
	}
	
	@Override
	public void news_update(NewsVO vo) {
		dao.news_update(vo);
	}
	
	// 이전 이후 글
	@Override
	public NewsVO news_prev(String cate, String seq) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cate", cate);
		map.put("seq", seq);
		return dao.news_prev(map);
	}
	@Override
	public NewsVO news_next(String cate, String seq) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cate", cate);
		map.put("seq", seq);
		return dao.news_next(map);
	}
	@Override
	public List<NewsVO> event_list(PageMapper mapper) {
		int total = dao.event_total();
		// mapper 객체 초기화
		mapper.setMapper(total);
		return dao.event_list(mapper);
	}

}
