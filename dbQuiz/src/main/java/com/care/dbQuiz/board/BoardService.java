package com.care.dbQuiz.board;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.dbQuiz.common.PageService;

@Service
public class BoardService {
	@Autowired private BoardMapper boardMapper;
	@Autowired private HttpSession session;
	
	public void boardForm(Model model, String cp) {
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(cp);
		}catch(Exception e){
			currentPage = 1;
		}
		int pageBlock = 3; // 한 페이지에 보일 데이터의 수 
		int end = pageBlock * currentPage; // 테이블에서 가져올 마지막 행번호
		int begin = end - pageBlock + 1; // 테이블에서 가져올 시작 행번호
			
		ArrayList<BoardDTO> boards = boardMapper.boardForm(begin, end);
		int totalCount = boardMapper.count();

		String url = "boardForm?currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);	
		
		model.addAttribute("result", result);
		model.addAttribute("boards", boards);
		model.addAttribute("currentPage", currentPage);
	}

	public boolean boardWriteService(MultipartHttpServletRequest multi) {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty())
			return false;
		
		BoardDTO board = new BoardDTO();
		board.setId(id);
		board.setTitle(multi.getParameter("title"));
		board.setContent(multi.getParameter("content"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		board.setWriteDate(sdf.format(new Date()));
		board.setFileName("");
		
		if(board.getTitle() == null || board.getTitle().isEmpty())
		return false;
		
		//boardWrite에서 선택한 파일을 업로드
		MultipartFile file = multi.getFile("upfile");
		//업로드된 파일의 이름을 가져온다.
		String fileName = file.getOriginalFilename();
		//파일의 크기를 불러와서 파일이 존재하는지 아닌지 검증한다.
		if(file.getSize() != 0) {
			// 파일의 중복을 해결하기 위해 시간의 데이터를 파일이름으로 구성함.
			sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar cal = Calendar.getInstance();//현재 날짜를 가져온다.
			//현재날짜 및 시간과 파일이름을 합쳐서 fileName에 대입한다.
			fileName = sdf.format(cal.getTime()) + fileName;
			board.setFileName(fileName);
			
			// 업로드 파일 저장 경로 
			String fileLocation = "C:\\javas\\upload\\";
			//C:\\javas\\upload\\fileName
			File save = new File(fileLocation + fileName);
			
			try {
				// 서버가 저장한 업로드 파일은 임시저장경로에 있는데 개발자가 원하는 경로로 이동
				file.transferTo(save);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		boardMapper.boardWriteService(board);
		return true;
	}

	public BoardDTO boardContent(Model model, String cp) {
		int no = 0;
		try{
			no = Integer.parseInt(cp);
		}catch(Exception e){
			return null;
		}
		
		BoardDTO board = boardMapper.selectNo(no);
		
		if(board == null){
			return null;
		}
		
		model.addAttribute("board", board);
		if(board.getFileName() != null ) {
			String fn = board.getFileName();
			String[] fileName = fn.split("-", 2);
			board.setFileName(fileName[1]);
		}
		return board;
	}

	public void hits(int no) {
		boardMapper.hits(no);
	}

	public boolean boardDownload(String cp, HttpServletResponse res) {
		int no = 0;
		try{
			no = Integer.parseInt(cp);
		}catch(Exception e){
			return false;
		}
		//데이터베이스에 저장된 파일이름 가져오기
		String fileName = boardMapper.boardDownload(no);
		if(fileName == null)
			return false;
		
		String location = "C:\\javas\\upload\\";
		File file = new File(location + fileName);
		
		try {
			String[] original = fileName.split("-", 2);
			res.setHeader("Content-Disposition", 
					"attachment;filename=" + URLEncoder.encode(original[1], "UTF-8"));
			FileInputStream fis = new FileInputStream(file);
			/*fis에서 받아온 파일을 res.getOutputStream()를 통해 클라이언트로 복사하여 전송한다.
			 * 전송이 끝나면 두 스트림을 모두 닫습니다.*/
			FileCopyUtils.copy(fis, res.getOutputStream());
			fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
		
	}

	public boolean boardModifyService(BoardDTO board) {
		if(board.getTitle() == null || board.getTitle().isEmpty()){
			return false;
		} 
		boardMapper.modify(board); 
		return true;
	}

	public boolean boardDelete(String id, String cp) {
	 	int no = 0;
		try{
			no = Integer.parseInt(cp);
		}catch(Exception e){
			return false;
		}
		
		BoardDTO board = boardMapper.selectNo(no);
		
		if(board == null){
			return false;
		}
		if(id.equals(board.getId()) == false){
			return false;
		}
		// 테이블 삭제, 파일삭제
		boardMapper.delete(no);
		
		String saveDir = "C:\\javas\\upload\\"+ board.getFileName();
		File f = new File(saveDir);
		if(f.exists() == true){
			f.delete();	
		}
		return true;
	}

}
