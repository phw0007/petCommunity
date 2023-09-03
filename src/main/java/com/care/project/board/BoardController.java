package com.care.project.board;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	@Autowired private BoardService service;
	@Autowired private HttpSession session;
	

	/*boardFormMapping*/
	@RequestMapping("freeboardForm")
	public String freeboardForm(@RequestParam(value="currentPage", required=false)String cp,Model model) {
		service.freeboardForm(cp, model);
		return "board/freeboardForm";
	}
	@RequestMapping("infoboardForm")
	public String infoboardForm(@RequestParam(value="currentPage", required=false)String cp,Model model) {
		service.infoboardForm(cp, model);
		return "board/infoboardForm";
	}
	@RequestMapping("qNaboardForm")
	public String qNaboardForm(@RequestParam(value="currentPage", required=false)String cp,Model model) {
		service.qNaboardForm(cp, model);
		return "board/qNaboardForm";
	}
	@RequestMapping("dogboardForm")
	public String dogboardForm(@RequestParam(value="currentPage", required=false)String cp,Model model) {
		service.dogboardForm(cp, model);
		return "board/dogboardForm";
	}
	@RequestMapping("catboardForm")
	public String catboardForm(@RequestParam(value="currentPage", required=false)String cp,Model model) {
		service.catboardForm(cp, model);
		return "board/catboardForm";
	}
	@RequestMapping("reptileboardForm")
	public String reptileboardForm(@RequestParam(value="currentPage", required=false)String cp,Model model) {
		service.reptileboardForm(cp, model);
		return "board/reptileboardForm";
	}
	@RequestMapping("birdboardForm")
	public String birdboardForm(@RequestParam(value="currentPage", required=false)String cp,Model model) {
		service.birdboardForm(cp, model);
		return "board/birdboardForm";
	}
	@RequestMapping("fishboardForm")
	public String fishboardForm(@RequestParam(value="currentPage", required=false)String cp,Model model) {
		service.fishboardForm(cp, model);
		return "board/fishboardForm";
	}
	@RequestMapping("smallboardForm")
	public String smallboardForm(@RequestParam(value="currentPage", required=false)String cp,Model model) {
		service.smallboardForm(cp, model);
		return "board/smallboardForm";
	}
	@RequestMapping("etcboardForm")
	public String etcboardForm(@RequestParam(value="currentPage", required=false)String cp,Model model) {
		service.etcboardForm(cp, model);
		return "board/etcboardForm";
	}
	///////////////////////////////////////////////////////////////////////
	
	@GetMapping("boardWrite")
	public String boardWrite(@RequestParam(value="category", required = false)String category) {
	String id = (String)session.getAttribute("id");
	if(id == null || id.isEmpty()) {
	return "redirect:login";
	}
	return "board/boardWrite";
	}
	
	@PostMapping("boardWriteProc")
	public String boardWriteProc(Model model, MultipartHttpServletRequest multi,HttpServletRequest request) {
		String msg = service.boardWriteProc(multi);
		if(msg.equals("로그인")) {
			return "redirect:login";
		}
		if(msg.equals("게시글 작성 완료")) {
			if(multi.getParameter("category").equals("QnA")) {
				return "redirect:qNaboardForm";
			}else if(multi.getParameter("category").equals("강아지")) {
				return "redirect:dogboardForm";
			}else if(multi.getParameter("category").equals("고양이")) {
				return "redirect:catboardForm";
			}else if(multi.getParameter("category").equals("조류")) {
				return "redirect:birdboardForm";
			}else if(multi.getParameter("category").equals("수중생물")) {
				return "redirect:fistboardForm";
			}else if(multi.getParameter("category").equals("소동물")) {
				return "redirect:smallboardForm";
			}else if(multi.getParameter("category").equals("파충류")) {
				return "redirect:reptileboardForm";
			}else if(multi.getParameter("category").equals("기타동물")) {
				return "redirect:stcboardForm";
			}else
			return "redirect:freeboardForm"; //forward 해도 됨. 목적은 둘 다 boardForm으로 매핑 찾아가서 메서드 실행하려는 것이기 때문
		}
		model.addAttribute("msg", msg);
		return "board/boardWrite";
	}
	
	   @RequestMapping("boardContent")
	   public String boardContent(
	         @RequestParam(value="no", required = false)String n,
	         @RequestParam(value="category")String c,
	         @RequestParam(value="cp", required=false)String cp,
	         Model model) {
	      BoardDTO board = service.boardContent(n,cp);
	      BoardDTO boards = new BoardDTO();
	      ArrayList<BoardDTO> comments = service.boardComments(c,n);
	      System.out.println(n);
	      System.out.println("페이지"+cp);
	      if(board == null) {
	         System.out.println("boardContent 게시글 번호 : " + n);
	         return "redirect:freeboardForm";
	      }
	      String id=(String)session.getAttribute("id");
	      
	      model.addAttribute("deleteId", id);
	      model.addAttribute("board", board);
	      model.addAttribute("comments", comments);
	      model.addAttribute("cp",cp);
	      return "board/boardContent";
	   }
	
	
	
	@GetMapping("boardModify")
	public String boardModify(
			@RequestParam(value="no", required = false)String n,
			Model model) {
		
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "redirect:login";
		}
		
		BoardDTO board = service.boardModify(n);
		if(board == null)
			return "redirect:boardForm";
		
		if(id.equals(board.getId()) == false)
			return "redirect:boardContent?no="+n;
	
		model.addAttribute("board", board);
		return "board/boardModify";
	}
	
	@PostMapping("boardModifyProc")
	public String boardModifyProc(BoardDTO board
			) {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "redirect:login";
		}
		System.out.println("QBQB"+board.getCategory());
		String result = service.boardModifyProc(board);
		//String category=board.getCategory();
		
		int no=board.getNo();
		if(result.equals("게시글 수정 완료")) {
			if(board.getCategory().equals("QnA")) {
				return "redirect:qNaboardForm";
			}else if(board.getCategory().equals("자유게시판")) {
				return "redirect:freeboardForm";			
			}else if(board.getCategory().equals("강아지")) {
				return "redirect:dogboardForm";			
			}else if(board.getCategory().equals("고양이")) {
				return "redirect:catboardForm";			
			}else if(board.getCategory().equals("조류")) {
				return "redirect:birdboardForm";			
			}else if(board.getCategory().equals("수중생물")) {
				return "redirect:fishboardForm";			
			}else if(board.getCategory().equals("파충류")) {
				return "redirect:reptileboardForm";			
			}else if(board.getCategory().equals("소동물")) {
				return "redirect:smallboardForm";			
			}else if(board.getCategory().equals("기타동물")) {
				return "redirect:etcboardForm";			
			}
			
		}
		return "board/freeboardForm"; // 실패했을 때 게시글 수정하는 자리로 간다고 하면, board/boardModify가 될 수 없음(보드에 들어갈 내용이 없으니까. redirect로 가야 함)
	}

	@RequestMapping("boardDeleteProc")
	public String boardDeleteProc(String selected,
			Model model) {
		String msg = service.boardDeleteProc(selected);
	
		String[] check = selected.split(",");
		String category=check[1];
		
		System.out.println("카테고리"+category);
		if(msg.equals("로그인"))
			return "redirect:login";

		if(msg.equals("작성자만 삭제 할 수 있습니다.")) {
			String alert="작성자만 삭제할 수 있습니다.";
			model.addAttribute("alert",alert);
			return "redirect:login";
		}
        if(msg.equals("게시글 삭제 완료")) {
        	if(category.equals("자유게시판")) {
		     return "redirect:freeboardForm";
            }else if(category.equals("QnA")) {
            	return "redirect:qNaboardForm";
            }else if(category.equals("강아지")) {
            	return "redirect:dogboardForm";
            }else if(category.equals("고양이")) {
            	return "redirect:catboardForm";
            }else if(category.equals("조류")) {
            	return "redirect:birdboardForm";
            }else if(category.equals("수중생물")) {
            	return "redirect:fishboardForm";
            }else if(category.equals("파충류")) {
            	return "redirect:reptileboardForm";
            }else if(category.equals("기타동물")) {
            	return "redirect:etcboardForm";
            }else if(category.equals("소동물")) {
            	return "redirect:smallboardForm";
            }
	}
        return "board/freeboardForm";
	}

	
	@ResponseBody
	@PostMapping(value = "uploadImage2", produces = "text/plain; charset=utf-8")
	public String uploadImage(@RequestParam(value = "imageFile", required = false) MultipartFile emailFile,
			@RequestParam("fileName") String fileName) {
		System.out.println(fileName);
		service.uploadImage(emailFile, fileName);
		return "redirect:boardContent";
	}
	
	@PostMapping("freecommentProc")
	public String freecommentProc(@RequestParam(value="no", required = false)String n,
		    @RequestParam(value = "category", required = false) String category,
		    HttpServletRequest request,
			BoardDTO board, Model model) {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "redirect:login";
		}
		System.out.println(board.getCategory());
		String result = service.freecommtentProc(board);

		if(result.equals("댓글 작성 완료")) {
			  String referer = request.getHeader("Referer");
	    	    return "redirect:"+ referer;//forward 해도 됨. 목적은 둘 다 boardForm으로 매핑 찾아가서 메서드 실행하려는 것이기 때문
		}
	   
		return "board/boardContent";
	}
	
	@PostMapping("commentDelete")
	public String commentDelete(String selectedValues) {
		
		String url= service.commentDeleteProc(selectedValues);
		System.out.println(url);
      return "forward:boardContent?"+url;
      
	}
	
	   @PostMapping("clickLike")
	   public String clickLikeButton(String selectedValues, Model model,HttpServletRequest request) {
		   
		   System.out.println(selectedValues);
	      String url = service.boardLikeButton(selectedValues);
	      if(url.equals("로그인이 필요합니다.")) {
	    	  model.addAttribute("errorMessage", "로그인이 필요한 작업입니다."); // 에러 메시지 모델에 추가
	    	  String referer = request.getHeader("Referer");
	    	    return "redirect:"+ referer;
	      }
	      System.out.println(url);
	      return "forward:boardContent?"+url;
	   }
	   
	 /*board카테고리별 검색*/
	@RequestMapping("boardSearch")
	public String freeboardSearch(@RequestParam(value="currentPage", required=false)String cp, 
			String select, @RequestParam(value = "category", required = false) String category, String search, Model model) {
		System.out.println("알려쥬" + select);
		System.out.println("이것동"+search);
		System.out.println("카테고링"+category);
		if(select == null || select.equals("")) {
			service.freeboardForm(cp, model);
			return "board/freeboardForm";
		}
		if(category.equals("자유게시판")) {
		service.boardSearch(cp, select, search, model,category);
		return "board/freeboardForm";
		}else if(category.equals("QnA")) {
			service.boardSearch(cp, select, search, model,category);
			return "board/qNaboardForm";
		}else if(category.equals("강아지")) {
			service.boardSearch(cp, select, search, model,category);
			return "board/dogboardForm";
		}else if(category.equals("고양이")) {
			service.boardSearch(cp, select, search, model,category);
			return "board/catboardForm";
		}else if(category.equals("파충류")) {
			service.boardSearch(cp, select, search, model,category);
			return "board/reptileboardForm";
		}else if(category.equals("조류")) {
			service.boardSearch(cp, select, search, model,category);
			return "board/birdboardForm";
		}else if(category.equals("수중생물")) {
			service.boardSearch(cp, select, search, model,category);
			return "board/fishboardForm";
		}else if(category.equals("소동물")) {
			service.boardSearch(cp, select, search, model,category);
			return "board/smallboardForm";
		}else if(category.equals("기타동물")) {
			service.boardSearch(cp, select, search, model,category);
			return "board/etcboardForm";
		}
   
		return "board/freeboardForm";
		
	
}
	
	
	
	
//	@RequestMapping("catboardSearch")
//	public String catboardSearch(@RequestParam(value="currentPage", required=false)String cp, 
//			String select, @RequestParam(value = "category", required = false) String category, String search, Model model) {
//		System.out.println("알려쥬" + select);
//		System.out.println("이것동"+search);
//		System.out.println("카테고링"+category);
//		service.catboardSearch(cp, select, search, model,category);
//		return "board/catboardForm";
//	}
}