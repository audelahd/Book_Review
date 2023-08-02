package com.myspring.pro30.board.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.pro30.board.service.BoardService;
import com.myspring.pro30.board.vo.ArticleVO;
import com.myspring.pro30.book.vo.BookVO;
import com.myspring.pro30.member.vo.MemberVO;

@Controller("boardController")
public class BoardControllerImpl implements BoardController {
	private static final String ARTICLE_IMAGE_REPO = "C:\\board\\article_image";
	
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private ArticleVO articleVO;

	//전체 후기 리스트 
	@Override // board/listArticles.do일때 실행된다.
	@RequestMapping(value = "/board/listArticles.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List articlesList = boardService.listArticles(); //리스트를 생성한다. boardService의 listArticles 메소드 호출
		ModelAndView mav = new ModelAndView(viewName); 
		mav.addObject("articlesList", articlesList); //그대로 모델에 넣어서 연결된 jsp로 보여준다.
		return mav;

	}
	
	
	//특정 책 후기 리스트 
	@Override // 마찬가지로 board/listArticles.do일때 실행된다.
	@RequestMapping(value="/board/listReviews.do", method= { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listArticles(@RequestParam("booktitle_")String booktitle_, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//위 메소드와 전부 같지만 booktitle_이라는 스트링값을 전달해서 다른 리스트를 반환하기 때문에 결과가 다르다.
		String viewName = (String) request.getAttribute("viewName");
		List articlesList = boardService.listArticles(booktitle_);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("articlesList", articlesList); //마찬가지로 모델에 넣어서 연결된 jsp로 보여준다.
		return mav;
	}


	//테스트용 메인 홈 페이지 
	@RequestMapping(value = "/home")
	public String home() {
		return "/home";
	}

	
	//후기를 추천하기
	@Override // board/recoUp.do일때 실행된다.
	@RequestMapping(value = "/board/recoUp.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity recoUp(@RequestParam("articleNO") int articleNO, HttpServletRequest request,
			HttpServletResponse response) throws Exception { //어떤 후기를 추천할지 번호를 받아온다.

		response.setContentType("text/html; charset=UTF-8"); 
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		String message;

		boardService.RECOUP(articleNO); //후기 글 번호를 받아서 그대로 추천 수 올리는 Service 메소드로 보낸다.
		System.out.println(request.getContextPath());
		message = "<script> alert('추천되었습니다'); location.href='" + request.getContextPath();
		message += "/board/listArticles.do'; </script>"; //메세지를 실행하며 후기 목록으로 돌아간다. (글 번호보다 더 쉽게 볼 수 있음)
		resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		return resEnt;
	}
	
	//후기 작성하기
	@Override // board/addNewArticle.do일때 실행된다.
	@RequestMapping(value = "/board/addNewArticle.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addNewArticle( MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> articleMap = new HashMap<String, Object>(); 
		Enumeration enu = multipartRequest.getParameterNames();

		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multipartRequest.getParameter(name);
			articleMap.put(name, value);
		}

		String imageFileName = upload(multipartRequest);
		HttpSession session = multipartRequest.getSession();
		
		MemberVO memberVO = (MemberVO) session.getAttribute("member"); //현재 로그인하고 있는 정보를 넘긴다
		String id = memberVO.getId(); //memberVO의 id를 넘김 

		articleMap.put("parentNO", 0); 
		articleMap.put("id", id);
		//입력할 정보가 아닌 기본 정보들을 그대로 넘긴다
		
		String message; //글이 등록되고 나서 띄워줄 메세지
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");

		try {
			int articleNO = boardService.addNewArticle(articleMap); 
			//위에서 넘긴 정보들을 boardService의 후기 추가 메소드로 넘긴다.
			
			message = "<script>";
			message += " alert('글이 제대로 작성됨');";
			message += " location.href='" + multipartRequest.getContextPath() + "/board/listArticles.do'; ";
			message += " </script>"; //alert문을 넘기면 listArticles.do가 실행되며 후기 목록으로 이동함.
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		} catch (Exception e) {

			message = " <script>";
			message += " alert('글이 제대로 작성되지 않았음');";
			message += " location.href='" + multipartRequest.getContextPath() + "/board/articleForm.do'; ";
			message += " </script>"; //alert문을 넘기면 listArticles.do가 실행되며 후기 목록으로 이동함.
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}

	// 후기 조회
	// board/viewArticle.do 일때 실행된다.
	@RequestMapping(value = "/board/viewArticle.do", method = RequestMethod.GET)
	public ModelAndView viewArticle(@RequestParam("articleNO") int articleNO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//후기 글 번호를 기준으로 상세 페이지를 조회하기 때문에 articleNO를 받아온다.
		String viewName = (String) request.getAttribute("viewName");
		articleVO = boardService.viewArticle(articleNO); //그 글 번호를 boardService의 조회 메소드로 넘긴다.
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("article", articleVO); //조회된 정보를 리턴한다.
		return mav;
	}

	// 후기 수정
	// board/modArticle.do 일때 실행된다.
	@RequestMapping(value = "/board/modArticle.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity modArticle(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> articleMap = new HashMap<String, Object>();
		Enumeration enu = multipartRequest.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multipartRequest.getParameter(name);
			articleMap.put(name, value);
		}

		//기본 형식은 후기 추가(등록)와 같은 형식이다. 단, 연결되는 메소드에서 insert가 아니라 update문으로 실행된다. 
		String articleNO = (String) articleMap.get("articleNO");
		String message; //수정이 실행되고 출력될 메세지 
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			boardService.modArticle(articleMap); //articleMap의 데이터를 boardService의 수정 메소드로 넘긴다.
			message = "<script>";
			message += " alert('글이 수정됨'); ";
			message += " location.href='" + multipartRequest.getContextPath() + "/board/viewArticle.do?articleNO="
					+ articleNO + "';"; //수정된 모습을 볼 수 있도록 수정된 후기로 링크된다.
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			message = "<script>";
			message += " alert('글이 제대로 수정되지 않음'); ";
			message += " location.href='" + multipartRequest.getContextPath() + "/board/viewArticle.do?articleNO="
					+ articleNO + "';"; //수정되지 않았더라도 원래 조회하고 있던 후기로 링크함.
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}
		return resEnt;
	}

	// 후기 삭제
	// board/removeArticle.do 일때 실행된다.
	@Override
	@RequestMapping(value = "/board/removeArticle.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity removeArticle(@RequestParam("articleNO") int articleNO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//후기 글 번호를 기준으로 삭제되기 때문에 articleNO를 받아온다.
		response.setContentType("text/html; charset=UTF-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			boardService.removeArticle(articleNO); //boardService의 삭제 메소드로 후기 글 번호를 넘겨서 실행한다.

			message = "<script>";
			message += " alert('글이 삭제됨'); ";
			message += " location.href='" + request.getContextPath() + "/board/listArticles.do';";
			message += " </script>"; //후기가 삭제되고 나면 후기 목록으로 돌아와서 삭제됐는지 확인할 수 있게 한다.
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		} catch (Exception e) {
			message = "<script>";
			message += " alert('글이 제대로 삭제되지 않음'); ";
			message += " location.href='" + request.getContextPath() + "/board/listArticles.do';";
			message += " </script>";  //마찬가지로 후기가 삭제되지 않았을 경우에도 후기 목록으로 돌려보낸다.
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}



	@RequestMapping(value = "/board/*Form.do", method = RequestMethod.GET)
	private ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	
	private String upload(MultipartHttpServletRequest multipartRequest) throws Exception { //이미지 파일을 올릴 경우 사용한 메소드
		String imageFileName = null;
		Iterator<String> fileNames = multipartRequest.getFileNames();

		while (fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			imageFileName = mFile.getOriginalFilename();
			File file = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + fileName);
			if (mFile.getSize() != 0) { 
				if (!file.exists()) {
					file.getParentFile().mkdirs(); 
					mFile.transferTo(new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName)); 
																											
																											
																											
																											
				}
			}

		}
		return imageFileName;
	}

	
}
