package kr.co.museum.board.research;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.co.museum.utils.FileUtil;
import kr.co.museum.utils.FileVO;
import kr.co.museum.utils.PageMapper;

@Controller
public class BoardController {
	@Inject
	BoardService service;

	// 할일 : 모델 객체에 속성 부여할 map 객체 생성하기
	private Map<String, String> donationlistMap = new HashMap<String, String>();
	private Map<String, String> collectionlistMap = new HashMap<String, String>();

	public BoardController() {
		// donationlist
		donationlistMap.put("content", "research");
		donationlistMap.put("index", "1");
		donationlistMap.put("cate", "donationlist");
		
		// collectionlist
		collectionlistMap.put("content", "research");
		collectionlistMap.put("index", "2");
		collectionlistMap.put("cate", "collectionlist");
	}
	
	
	// 기증 내역 : 리스트 페이지
	@RequestMapping(value = "/donationlist")
	public String donationlist(Model model, PageMapper mapper) {
		// 게시판 글 갯수
		int total = service.total_board_dona();
		model.addAttribute("total", total);

		List<BoardVO> voList = null;

		// 검색 했을 경우
		String value = mapper.getSearchValue();
		if (value != "" && value != null) {
			System.out.println(mapper.getSearchField());
			System.out.println(value);
			voList = service.donation_search(mapper);
		} else {
			// mapper 객체 변수 설정
			mapper.setMapper(total);
			model.addAttribute("mapper", mapper);
			
			// 게시판 목록
			voList = service.normal_list(mapper);
		}
		model.addAttribute("voList", voList);

		// 리스트 창 활성화
		model.addAllAttributes(donationlistMap);

		return "/content/research/donationlist";
	}

	// 기증 내역 : 뷰페이지
	@RequestMapping(value = "/donationlist_view")
	public String donationlistView(Model model, String seq) {
		// 리스트 창 활성화
		model.addAllAttributes(donationlistMap);

		// 글 정보
		BoardVO vo = service.normal_view(seq);
		model.addAttribute("vo", vo);

		return "/content/research/donationlist_view";
	}

	// 기증 내역 : 글수정 페이지
	@RequestMapping(value = "/donationlist_update")
	public String donationlistUpdate(Model model, HttpSession session, String seq) {
		// admin 계정일 경우
		if (service.authAdmin(session)) {
			// 리스트 창 활성화
			model.addAllAttributes(donationlistMap);

			// 글 정보
			BoardVO vo = service.normal_view(seq);
			model.addAttribute("vo", vo);

			return "/content/research/donationlist_update";
		} else {
			return "redirect:/donationlist";
		}
	}

	// 기증 내역 : 글수정
	@RequestMapping(value = "/donationlist_update", method = RequestMethod.POST)
	public String donationlistUpdate(HttpSession session, BoardVO vo) {
		// admin 계정일 경우
		if (service.authAdmin(session)) {
			service.normal_update(vo);

			return "redirect:/donationlist";
		} else {
			return "redirect:/donationlist";
		}
	}

	// 기증 내역 : 글쓰기 페이지
	@RequestMapping(value = "/donationlist_write")
	public String donationlistWrite(Model model, HttpSession session) {
		// admin 계정일 경우
		if (service.authAdmin(session)) {
			// 리스트 창 활성화
			model.addAllAttributes(donationlistMap);
			
			return "/content/research/donationlist_write";
		} else {
			return "redirect:/";
		}
	}

	// 기증 내역 : 글쓰기
	@RequestMapping(value = "/donationlist_write", method = RequestMethod.POST)
	public String donationlistWrite(HttpSession session, MultipartFile fname, BoardVO vo) throws Exception {
		// admin 계정일 경우
		if (service.authAdmin(session)) {
			// 파일 저장 경로
			String target = FileUtil.getPath(session);

			String oName = null;
			String uName = null;

			// vo 객체 카테고리 설정
			vo.setCate("donationlist");

			// 파일 업로드
			MultipartFile file = fname;
			// 파일이 첨부되었을 때
			if (!file.isEmpty()) {
				oName = file.getOriginalFilename();

				String ext = oName.substring(oName.lastIndexOf("."));
				uName = UUID.randomUUID().toString() + ext;

				file.transferTo(new File(target + uName));

				// BoardVO에 이미지 경로, 이름 설정하기
				vo.setImg_src("/museum/data/" + uName);
				vo.setImg_name(oName);

				// 데이터베이스 입력
				int seq = service.normal_write(vo);

				FileVO fvo = new FileVO();
				fvo.setBoard_cate(vo.getCate());
				fvo.setBoard_seq(seq);
				fvo.setOrigin_name(oName);
				fvo.setStored_name(uName);
				service.file_insert(fvo);
			} else {
				// 데이터베이스 입력
				service.normal_write(vo);
			}

			return "redirect:/donationlist";
		} else {
			return "redirect:/";
		}
	}

	// 기증 내역 : 글삭제
	@RequestMapping(value = "/donationlist_delete")
	public String donationlistDelete(HttpSession session, String seq) {
		// admin 계정일 경우
		if (service.authAdmin(session)) {
			// 파일 경로 찾기
			FileVO fvo = service.file_select(seq);
			// 파일 테이블이 존재할 때
			if (fvo != null) {
				String target = FileUtil.getPath(session);
				String fname = fvo.getStored_name();
				
				// 파일 삭제
				FileUtil.deleteFile(target + fname);
				
				// 파일 테이블 삭제
				service.file_delete(fvo);
			}

			// 글삭제
			service.normal_delete(seq);
		}

		return "redirect:/donationlist";
	}

	// 소장 자료 검색 : 리스트 페이지
	@RequestMapping(value = "/collectionlist")
	public String collectionlist(Model model, PageMapper mapper) {
		// 리스트 창 활성화
		model.addAllAttributes(collectionlistMap);

		// 게시판 글 갯수
		int total = service.total_collection_list();
		model.addAttribute("total", total);

		// mapper 객체 변수 설정
		mapper.setMapper(total);
		model.addAttribute("mapper", mapper);

		// 게시판 목록
		List<BoardVO> voList = service.collection_list(mapper);
		model.addAttribute("voList", voList);

		return "/content/research/collectionlist";
	}

	// 소장 자료 검색 : 뷰페이지
	@RequestMapping(value = "/collectionlist_view")
	public String collectionlistView(Model model, String seq) {
		// 리스트 창 활성화
		model.addAllAttributes(collectionlistMap);

		// 글 정보
		BoardVO vo = service.normal_view(seq);
		model.addAttribute("vo", vo);

		return "/content/research/collectionlist_view";
	}

	// 소장 자료 검색 : 글쓰기 페이지
	@RequestMapping(value = "/collectionlist_write")
	public String collectionlistWrite(Model model, HttpSession session) {
		// admin 계정일 경우
		if (service.authAdmin(session)) {
			// 리스트 창 활성화
			model.addAllAttributes(collectionlistMap);

			return "/content/research/collectionlist_write";
		} else {
			return "redirect:/";
		}
	}

	// 소장 자료 검색 : 글수정 페이지
	@RequestMapping(value = "/collectionlist_update")
	public String collectionlistUpdate(Model model, HttpSession session, String seq) {
		// admin 계정일 경우
		if (service.authAdmin(session)) {
			// 리스트 창 활성화
			model.addAllAttributes(collectionlistMap);

			// 글 정보
			BoardVO vo = service.normal_view(seq);
			model.addAttribute("vo", vo);

			return "/content/research/collectionlist_update";
		} else {
			return "redirect:/collectionlist";
		}
	}

	// 소장 자료 검색 : 글수정
	@RequestMapping(value = "/collectionlist_update", method = RequestMethod.POST)
	public String collectionlistUpdate(HttpSession session, BoardVO vo) {
		// admin 계정일 경우
		if (service.authAdmin(session)) {
			service.collection_update(vo);

			return "redirect:/collectionlist";
		} else {
			return "redirect:/collectionlist";
		}
	}

	// 소장 자료 검색 : 글쓰기
	@RequestMapping(value = "/collectionlist_write", method = RequestMethod.POST)
	public String collectionlistWrite(HttpSession session, MultipartFile fname, BoardVO vo) throws Exception {
		// admin 계정일 경우
		if (service.authAdmin(session)) {
			// 파일 저장 경로
			String target = FileUtil.getPath(session);

			String oName = null;
			String uName = null;

			// vo 객체 카테고리 설정
			vo.setCate("collectionlist");

			// 파일 업로드
			MultipartFile file = fname;
			// 파일이 첨부되었을 때
			if (!file.isEmpty()) {
				oName = file.getOriginalFilename();

				String ext = oName.substring(oName.lastIndexOf("."));
				uName = UUID.randomUUID().toString() + ext;

				file.transferTo(new File(target + uName));

				// BoardVO에 이미지 경로, 이름 설정하기
				vo.setImg_src("/museum/data/" + uName);
				vo.setImg_name(oName);

				// 데이터베이스 입력
				int seq = service.normal_write(vo);

				FileVO fvo = new FileVO();
				fvo.setBoard_cate(vo.getCate());
				fvo.setBoard_seq(seq);
				fvo.setOrigin_name(oName);
				fvo.setStored_name(uName);
				service.file_insert(fvo);
			} else {
				// 데이터베이스 입력
				service.normal_write(vo);
			}

			return "redirect:/collectionlist";
		} else {
			return "redirect:/";
		}
	}

	// 소장 자료 검색 : 글삭제
	@RequestMapping(value = "/collectionlist_delete")
	public String collectionlistDelete(HttpSession session, String seq) {
		// admin 계정일 경우
		if (service.authAdmin(session)) {
			// 파일 경로 찾기
			FileVO fvo = service.file_select(seq);
			// 파일 테이블이 존재할 때
			if (fvo != null) {
				String target = FileUtil.getPath(session);
				String fname = fvo.getStored_name();

				// 파일 삭제
				FileUtil.deleteFile(target + fname);

				// 파일 테이블 삭제
				service.file_delete(fvo);
			}

			// 글삭제
			service.normal_delete(seq);
		}

		return "redirect:/collectionlist";
	}
}
