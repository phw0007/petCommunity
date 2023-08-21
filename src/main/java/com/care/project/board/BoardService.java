package com.care.project.board;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.project.common.PageService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class BoardService {
	@Autowired private BoardMapper boardMapper;
	@Autowired private HttpSession session;
	
	public void freeboardForm(String cp, Model model) {
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(cp);
		}catch(Exception e){
			currentPage = 1;
		}
		
		int pageBlock = 10; // 한 페이지에 보일 데이터의 수 
		int end = pageBlock * currentPage; // 테이블에서 가져올 마지막 행번호
		int begin = end - pageBlock + 1; // 테이블에서 가져올 시작 행번호
	    
		
		
		ArrayList<BoardDTO> freeboards = boardMapper.freeboardForm(begin, end);
		int totalCount = boardMapper.freecount();
		String url = "freeboardForm?currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		
		model.addAttribute("boards", freeboards);
		model.addAttribute("result", result);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", currentPage);
		
	}
	public void qNaboardForm(String cp, Model model) {
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(cp);
		}catch(Exception e){
			currentPage = 1;
		}
		
		int pageBlock = 10; // 한 페이지에 보일 데이터의 수 
		int end = pageBlock * currentPage; // 테이블에서 가져올 마지막 행번호
		int begin = end - pageBlock + 1; // 테이블에서 가져올 시작 행번호
	    
	
		
		ArrayList<BoardDTO> qNaboards = boardMapper.qNaboardForm(begin, end);
		int totalCount = boardMapper.qNacount();
		String url = "qNaboardForm?currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		
		model.addAttribute("boards", qNaboards);
		model.addAttribute("result", result);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", currentPage);
		
	}
	public void dogboardForm(String cp, Model model) {
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(cp);
		}catch(Exception e){
			currentPage = 1;
		}
		
		int pageBlock = 10; // 한 페이지에 보일 데이터의 수 
		int end = pageBlock * currentPage; // 테이블에서 가져올 마지막 행번호
		int begin = end - pageBlock + 1; // 테이블에서 가져올 시작 행번호
	    
		
		
		ArrayList<BoardDTO> dogboards = boardMapper.dogboardForm(begin, end);
		int totalCount = boardMapper.dogcount();
		String url = "dogboardForm?currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		
		model.addAttribute("boards", dogboards);
		model.addAttribute("result", result);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", currentPage);
		
	}
	public void catboardForm(String cp, Model model) {
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(cp);
		}catch(Exception e){
			currentPage = 1;
		}
		
		int pageBlock = 10; // 한 페이지에 보일 데이터의 수 
		int end = pageBlock * currentPage; // 테이블에서 가져올 마지막 행번호
		int begin = end - pageBlock + 1; // 테이블에서 가져올 시작 행번호
	    
		
		
		ArrayList<BoardDTO> catboards = boardMapper.catboardForm(begin, end);
		int totalCount = boardMapper.catcount();
		String url = "catboardForm?currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		
		model.addAttribute("boards", catboards);
		model.addAttribute("result", result);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", currentPage);
		
	}
	public void reptileboardForm(String cp, Model model) {
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(cp);
		}catch(Exception e){
			currentPage = 1;
		}
		
		int pageBlock = 10; // 한 페이지에 보일 데이터의 수 
		int end = pageBlock * currentPage; // 테이블에서 가져올 마지막 행번호
		int begin = end - pageBlock + 1; // 테이블에서 가져올 시작 행번호
	    
		
		
		ArrayList<BoardDTO> reptileboards = boardMapper.reptileboardForm(begin, end);
		int totalCount = boardMapper.reptilecount();
		String url = "reptileboardForm?currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		
		model.addAttribute("boards", reptileboards);
		model.addAttribute("result", result);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", currentPage);
		
	}
	public void birdboardForm(String cp, Model model) {
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(cp);
		}catch(Exception e){
			currentPage = 1;
		}
		
		int pageBlock = 10; // 한 페이지에 보일 데이터의 수 
		int end = pageBlock * currentPage; // 테이블에서 가져올 마지막 행번호
		int begin = end - pageBlock + 1; // 테이블에서 가져올 시작 행번호
	    
		
		
		ArrayList<BoardDTO> birdboards = boardMapper.birdboardForm(begin, end);
		int totalCount = boardMapper.birdcount();
		String url = "birdboardForm?currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		
		model.addAttribute("boards", birdboards);
		model.addAttribute("result", result);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", currentPage);
		
	}
	public void fishboardForm(String cp, Model model) {
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(cp);
		}catch(Exception e){
			currentPage = 1;
		}
		
		int pageBlock = 10; // 한 페이지에 보일 데이터의 수 
		int end = pageBlock * currentPage; // 테이블에서 가져올 마지막 행번호
		int begin = end - pageBlock + 1; // 테이블에서 가져올 시작 행번호
	    
		
		
		ArrayList<BoardDTO> fishboards = boardMapper.fishboardForm(begin, end);
		int totalCount = boardMapper.fishcount();
		String url = "fishboardForm?currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		
		model.addAttribute("boards", fishboards);
		model.addAttribute("result", result);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", currentPage);
		
	}
	
	public void smallboardForm(String cp, Model model) {
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(cp);
		}catch(Exception e){
			currentPage = 1;
		}
		
		int pageBlock = 10; // 한 페이지에 보일 데이터의 수 
		int end = pageBlock * currentPage; // 테이블에서 가져올 마지막 행번호
		int begin = end - pageBlock + 1; // 테이블에서 가져올 시작 행번호
	    
		
		
		ArrayList<BoardDTO> smallboards = boardMapper.smallboardForm(begin, end);
		int totalCount = boardMapper.smallcount();
		String url = "fishboardForm?currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		
		model.addAttribute("boards", smallboards);
		model.addAttribute("result", result);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", currentPage);
		
	}
	public void etcboardForm(String cp, Model model) {
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(cp);
		}catch(Exception e){
			currentPage = 1;
		}
		
		int pageBlock = 10; // 한 페이지에 보일 데이터의 수 
		int end = pageBlock * currentPage; // 테이블에서 가져올 마지막 행번호
		int begin = end - pageBlock + 1; // 테이블에서 가져올 시작 행번호
	    
		
		
		ArrayList<BoardDTO> etcboards = boardMapper.etcboardForm(begin, end);
		int totalCount = boardMapper.etccount();
		String url = "fishboardForm?currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		
		model.addAttribute("boards", etcboards);
		model.addAttribute("result", result);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", currentPage);
		
	}
//	public void boardForm(String cp, Model model) {
//		int currentPage = 1;
//		try{
//			currentPage = Integer.parseInt(cp);
//		}catch(Exception e){
//			currentPage = 1;
//		}
//		
//		int pageBlock = 10; // 한 페이지에 보일 데이터의 수 
//		int end = pageBlock * currentPage; // 테이블에서 가져올 마지막 행번호
//		int begin = end - pageBlock + 1; // 테이블에서 가져올 시작 행번호
//	
//		ArrayList<BoardDTO> boards = boardMapper.boardForm(begin, end);
//		int totalCount = boardMapper.count();
//		String url = "boardForm?currentPage=";
//		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
//		
//		model.addAttribute("boards", boards);
//		model.addAttribute("result", result);
//		model.addAttribute("currentPage", currentPage);
//	}

	public String boardWriteProc(MultipartHttpServletRequest multi) {
		
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "로그인";
		}
		
		BoardDTO board = new BoardDTO();
		board.setId(id);
		board.setCategory(multi.getParameter("category"));
		board.setTitle(multi.getParameter("title"));
		board.setContent(multi.getParameter("content"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		board.setWriteDate(sdf.format(new Date()));
		board.setFileName("");
		
		if(board.getTitle() == null || board.getTitle().isEmpty()) {
			return "제목을 입력하세요.";
		}
		if(board.getCategory() == null || board.getCategory().isEmpty()) {
			return "카테고리를 정해주세요.";
		}
		
		
		  List<MultipartFile> files = multi.getFiles("upfile"); // 여러 개의 파일 가져오기
		    List<String> savedFileNames = new ArrayList<>(); // 저장된 파일명들을 담을 리스트

		    for (MultipartFile file : files) {
		        String fileName = file.getOriginalFilename();
		        if (file.getSize() != 0) {
		            // 파일의 중복을 해결하기 위해 시간의 데이터를 파일이름으로 구성함.
		            SimpleDateFormat sdfFile  = new SimpleDateFormat("yyyyMMddHHmmss-");
		            Calendar cal = Calendar.getInstance();
		            fileName = sdfFile .format(cal.getTime()) + fileName;

		            String fileLocation = "C:\\javas\\boot_workspace\\petCommunity\\src\\main\\webapp\\image\\";
		            File save = new File(fileLocation + fileName);

		            try {
		                // 서버가 저장한 업로드 파일은 임시 저장 경로에 있는데 개발자가 원하는 경로로 이동
		                file.transferTo(save);
		                savedFileNames.add(fileName); // 저장된 파일명을 리스트에 추가
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		        }
		    }

		    // 저장된 파일명들을 photo 객체에 설정 (여러 개의 파일명을 쉼표로 구분하여 하나의 문자열로 저장)
		   board.setFileName(String.join(",", savedFileNames));

		
//		MultipartFile file = multi.getFile("upfile");
//		String fileName = file.getOriginalFilename();
//		if(file.getSize() != 0) {
//			// 파일의 중복을 해결하기 위해 시간의 데이터를 파일이름으로 구성함.
//			sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
//			Calendar cal = Calendar.getInstance();
//			fileName = sdf.format(cal.getTime()) + fileName;
//			board.setFileName(fileName);
			
// 업로드 파일 저장 경로
// ubuntu@ip-172-31-32-35:~$ sudo mkdir /opt/tomcat/tomcat-10/webapps/upload
// ubuntu@ip-172-31-32-35:~$ sudo chown -RH tomcat: /opt/tomcat/tomcat-10/webapps/upload
			//String fileLocation = "/opt/tomcat/tomcat-10/webapps/upload/";
			//File save = new File(fileLocation + fileName);
			
			//try {
				// 서버가 저장한 업로드 파일은 임시저장경로에 있는데 개발자가 원하는 경로로 이동
			//	file.transferTo(save);
			//} catch (Exception e) {
			//.printStackTrace();
			//}
		
		
		boardMapper.boardWriteProc(board);
		return "게시글 작성 완료";
	}

	public BoardDTO boardContent(String n,String cp) {
		int no = 0;
		try{
			no = Integer.parseInt(n);
		}catch(Exception e){
			return null;
		}
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(cp);
		}catch(Exception e){
			currentPage = 1;
		}
		
		BoardDTO board = boardMapper.boardContent(no);
		if(board == null) 
			return null;
		
		board.setHits(board.getHits()+1);
		incHit(board.getNo());

		//if(board.getFileName() == null) {
		//	System.out.println("널이얌");
		//}
		if (board.getFileName() != null && !board.getFileName().isEmpty()) {
	        try {
	            String[] fileNameParts = board.getFileName().split("-", 2);
	            board.setFileName(fileNameParts[1]);
	        } catch (Exception e) {
	            // 파일 이름 분리 실패
	            e.printStackTrace(); // 필요한 로깅
	            board.setFileName("파일 없음");
	        }
	    } else {
	        board.setFileName("파일 없음");
	    }
	
			return board;
	}
	
	public void incHit(int no) {
		boardMapper.incHit(no);
	}

	public boolean boardDownload(String n, HttpServletResponse res) {
		int no = 0;
		
		try{
			no = Integer.parseInt(n);
		}catch(Exception e){
			return false;
		}
		
		String fileName = boardMapper.boardDownload(no);
		if(fileName == null)
			return false;
		
		String location = "/opt/tomcat/tomcat-10/webapps/upload/";
		File file = new File(location + fileName);
		
		try {
			String[] original = fileName.split("-", 2);
			res.setHeader("Content-Disposition", 
					"attachment;filename=" + URLEncoder.encode(original[1], "UTF-8"));
			FileInputStream fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, res.getOutputStream());
			fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}

	public BoardDTO boardModify(String n) {
		int no = 0;
		try{
			no = Integer.parseInt(n);
		}catch(Exception e){
			return null;
		}
		
		BoardDTO board = boardMapper.boardContent(no);
		if(board == null)
			return null;

		if(board.getFileName() != null ) {
			String fn = board.getFileName();
			String[] fileName = fn.split("-", 2);
			board.setFileName(fileName[1]);
		}
		return board;
	}
	
	public String boardModifyProc(BoardDTO board) {
		if(board.getTitle() == null || board.getTitle().isEmpty())
			return "제목을 입력하세요.";
		
		boardMapper.boardModifyProc(board);
		return "게시글 수정 완료";
	}

	
	
	
	
	
	public void uploadImage(MultipartFile imageFile, String fileName) {
	      if(imageFile.isEmpty()) {
	         return;
	      }
	      if(imageFile.getSize() != 0) {
	         String fileLocation = "C:\\javas\\boot_workspace\\petCommunity\\src\\main\\webapp\\image\\"+fileName;
	         File save = new File(fileLocation);
             System.out.println(fileLocation);
	         try {
	            imageFile.transferTo(save);
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	      }
	   }
    
	/*자유게시판 댓글 등록*/
	public String freecommtentProc(BoardDTO board) {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "로그인";
		}
        
		BoardDTO free= new BoardDTO();
		free.setId(id);
		free.setCategory(board.getCategory());
		free.setNo(board.getNo());
		free.setCommentContent(board.getCommentContent());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		free.setWriteDate(sdf.format(new Date()));

		boardMapper.freecommentProc(free);
	
		return "댓글 작성 완료";
	}
	


	  public ArrayList<BoardDTO> boardComments(String c,String n) {
      int no = 0;
      try{
         no = Integer.parseInt(n);
      }catch(Exception e){
         return null;
      }
      ArrayList<BoardDTO> comments = boardMapper.freeComment(no,c);
      return comments;
   }

	  public String boardDeleteProc(String n) {
			String id = (String)session.getAttribute("id");
			if(id == null || id.isEmpty()) {
				return "로그인";
			}
			
			int no = 0;
			try{
				no = Integer.parseInt(n);
			}catch(Exception e){
				return "게시글 번호에 문제가 생겼습니다.";
			}
			
			BoardDTO board = boardMapper.boardContent(no);
			if(board == null)
				return "게시글 번호에 문제가 생겼습니다.";
			
			if(id.equals(board.getId()) == false)
				return "작성자만 삭제 할 수 있습니다.";
			
			boardMapper.boardDeleteProc(no);
			
			String path = "/opt/tomcat/tomcat-10/webapps/upload/" + board.getFileName();
			File file = new File(path);
			if(file.exists() == true) {
				file.delete();
			}
			
			return "게시글 삭제 완료";
		}

	public String commentDeleteProc(String selectedValues) {
		String[] check = selectedValues.split(",");
		int no = Integer.parseInt(check[0]);
		String id=check[1];
		String category=check[2];
		String cp=check[3];
		String writeDate=check[4];
		System.out.println(writeDate);
		boardMapper.commentDeleteProc(id,category,no,writeDate);
//String id = (String)session.getAttribute("id");
//		if(id == null || id.isEmpty()) {
//			return "로그인";
//		}
		return "id="+id+"&category="+category+"&no="+no+"&currentPage="+cp;
		//return "no="+no+"&category="+category+"&currentPage="+cp;
	}
	
	   public String boardLikeButton(String selectedValues) {
		      String[] checkData = selectedValues.split(",");
		      int no = Integer.parseInt(checkData[0]);
		      String id = checkData[1];
		      String category = checkData[2];
		      String cp = checkData[3];
		    
		      String likesId = (String)session.getAttribute("id");
		      if(likesId==null || likesId.isEmpty()) {
		    	  return "로그인이 필요합니다.";
		      }
		      BoardDTO boardDto = boardMapper.boardLikeCheck(id, category, no, likesId);
		      boardMapper.boardHitDown(id, category, no);
		      if(boardDto == null) {
		         boardMapper.boardLikeUserInsert(id, category, no, likesId);
		         boardMapper.boardLike(id, category, no);
		      }
		      return "id="+id+"&category="+category+"&no="+no+"&cp="+cp;
		      
		   }

	public void boardSearch(String cp, String select, String search, Model model,String category) {
		if(select == null){
			select = "";
		}
		
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(cp);
		}catch(Exception e){
			currentPage = 1;
		}
			
		if(search == null) {
			search = "";
		}
		System.out.println("카테고리 나올까? "+category);
		int pageBlock = 10; 
		int end = pageBlock * currentPage; 
		
		int begin = end - pageBlock + 1; 
		//int no = 0;
		ArrayList<BoardDTO> boards = boardMapper.boardSearch(begin, end, select, search,category);
		
		int totalCount = boardMapper.searchCount(select, search);
		System.out.println("길이뭘깡?"+totalCount);
		String url = "boardSearch?select="+select+"&search="+search+"&category="+category+"&currentPage=";
		//String url = "memberInfo?select=" + select + "&search=" + search + "&currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		//no = (currentPage-1)*10;
		model.addAttribute("boards", boards);
		model.addAttribute("result", result);
		model.addAttribute("currentPage", currentPage);
		//model.addAttribute("no", no);
		model.addAttribute("select", select);
		model.addAttribute("search", search);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("category", category);
		
	}
	
	

}








