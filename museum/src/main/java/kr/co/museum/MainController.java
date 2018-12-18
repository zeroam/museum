package kr.co.museum;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.museum.board.news.NewsVO;
import kr.co.museum.utils.FileUtil;
import kr.co.museum.utils.FileVO;

@Controller
public class MainController {
	@Inject
	MainService service;

	@RequestMapping(value="/")
	public String index() {
		return "content/index";
	}
	
	@RequestMapping(value="/content")
	public String content(String content, String cate, String index, Model model) {
		// 리스트 창 활성화
		model.addAttribute("content", content);
		model.addAttribute("cate", cate);
		model.addAttribute("index", index);
		
		return "/content/"+content+"/"+cate;
	}
	
	// 파일 다운로드
	@RequestMapping(value="/download")
	public void download(HttpSession session, HttpServletResponse response, String cate, String seq) throws Exception {		
		// 파일 테이블 가져오기
		Map<String, String> map = new HashMap<String, String>();
		map.put("cate", cate);
		map.put("seq", seq);
		
		FileVO fvo = service.select_file(map);
		String target = FileUtil.getPath(session);
		String oName = fvo.getOrigin_name();
		String sName = fvo.getStored_name();
		
		byte fileByte[] = FileUtils.readFileToByteArray(new File(target+sName));
		
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(oName, "UTF-8")+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.getOutputStream().write(fileByte);
		
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
	}
	
	// ajax 관련 메서드
	@ResponseBody
	@RequestMapping(value="/ajax/getNews")
	public List<NewsVO> getNews() {
		// json 형식으로 출력
		return service.get_news();
	}
	@ResponseBody
	@RequestMapping(value="/ajax/getEvent")
	public NewsVO getEvent() {
		return service.get_event();
	}
	
}
