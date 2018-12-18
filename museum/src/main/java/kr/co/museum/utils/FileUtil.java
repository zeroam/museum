package kr.co.museum.utils;

import java.io.File;

import javax.servlet.http.HttpSession;

public class FileUtil {
	// 파일 저장 경로
	public static String getPath(HttpSession session) {
		// 서버상의 실제 경로 -> /home/zeroam/www/museum/resources/data
		String path = session.getServletContext().getRealPath("/");
		String target = path + "resources" + File.separator + "data" + File.separator;
		
		return target;
	}
	
	public static boolean deleteFile(String path) {
		File file = new File(path);
		
		if(file.exists()) {
			// 파일 존재할 때
			if(file.delete()) {
				// 파일 삭제 성공
				return true;
			} else {
				// 파일 삭제 실패
				return false;
			}
		} else {
			// 파일이 존재하지 않음
			return false;
		}
	}
}
