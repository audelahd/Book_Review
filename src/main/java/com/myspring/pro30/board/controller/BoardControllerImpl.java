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

	//글 조회
	@Override
	@RequestMapping(value = "/board/listArticles.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List articlesList = boardService.listArticles();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("articlesList", articlesList);
		return mav;

	}
	
	

	@Override
	@RequestMapping(value="/board/listReviews.do", method= { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listArticles(@RequestParam("booktitle_")String booktitle_, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String viewName = (String) request.getAttribute("viewName");
		List articlesList = boardService.listArticles(booktitle_);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("articlesList", articlesList);
		return mav;
	}



	@RequestMapping(value = "/home")
	public String home() {
		return "/home";
	}

	// 글 추천
	@Override
	@RequestMapping(value = "/board/recoUp.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity recoUp(@RequestParam("articleNO") int articleNO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setContentType("text/html; charset=UTF-8");
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		String message;

		boardService.RECOUP(articleNO);
		System.out.println(request.getContextPath());
		message = "<script> alert('추천되었습니다'); location.href='" + request.getContextPath();
		message += "/board/listArticles.do'; </script>";
		resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		return resEnt;
	}
	/*
	 * //글 쓰기 전 과정
	 * 
	 * @Override
	 * 
	 * @RequestMapping(value = "/board/beforeArticleForm.do", method =
	 * RequestMethod.POST)
	 * 
	 * @ResponseBody public ResponseEntity articleForm(@RequestParam("booktitle")
	 * String booktitle, HttpServletRequest request, HttpServletResponse response)
	 * throws Exception {
	 * 
	 * System.out.println("여기 들어오긴함?");
	 * response.setContentType("text/html; charset=UTF-8"); ResponseEntity
	 * resEnt=null; HttpHeaders responseHeaders = new HttpHeaders();
	 * System.out.println("슉"); responseHeaders.add("Content-Type",
	 * "text/html; charset=utf-8"); String message;
	 * 
	 * ArticleVO articleVO = new ArticleVO(); articleVO.setBooktitle_(booktitle);
	 * System.out.println("확인용:"+articleVO.getBooktitle_());
	 * 
	 * System.out.println("======================="+request.getContextPath());
	 * message = "<script> alert('리뷰 페이지로 이동합니다.'); location.href='" +
	 * request.getContextPath(); message += "/board/articleForm.do'; </script>";
	 * resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	 * 
	 * return resEnt;
	 * 
	 * }
	 */

	// 글 쓰기
	@Override
	@RequestMapping(value = "/board/addNewArticle.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addNewArticle( MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception {
		System.out.println("addNewArticle 들어옴");
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> articleMap = new HashMap<String, Object>();
		Enumeration enu = multipartRequest.getParameterNames();

		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multipartRequest.getParameter(name);
			articleMap.put(name, value);
		}

		System.out.println("2");
		String imageFileName = upload(multipartRequest);
		System.out.println("2");
		HttpSession session = multipartRequest.getSession();
		System.out.println("2");
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		System.out.println("여기");
		String id = memberVO.getId();
		System.out.println("여기!!");

		String test = "아아악";

		articleMap.put("parentNO", 0);
		System.out.println("2");
		articleMap.put("id", id);
		System.out.println("2");
		

		// articleMap.put("imageFileName", imageFileName);

		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");

		try {
			int articleNO = boardService.addNewArticle(articleMap);
			if (imageFileName != null && imageFileName.length() != 0) {
				/*
				 * File srcFile = new File(ARTICLE_IMAGE_REPO+ "\\" + "temp"+ "\\" +
				 * imageFileName); File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO);
				 * FileUtils.moveFileToDirectory(srcFile, destDir,true);
				 */
			}
			message = "<script>";
			message += " alert('글이 제대로 작성됨');";
			message += " location.href='" + multipartRequest.getContextPath() + "/board/listArticles.do'; ";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
			srcFile.delete();

			message = " <script>";
			message += " alert('글이 제대로 작성되지 않았음');";
			message += " location.href='" + multipartRequest.getContextPath() + "/board/articleForm.do'; ";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}

	// 글 조회
	@RequestMapping(value = "/board/viewArticle.do", method = RequestMethod.GET)
	public ModelAndView viewArticle(@RequestParam("articleNO") int articleNO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		articleVO = boardService.viewArticle(articleNO);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("article", articleVO);
		return mav;
	}

	// 글 수정
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

		String imageFileName = upload(multipartRequest);
		articleMap.put("imageFileName", imageFileName);

		String articleNO = (String) articleMap.get("articleNO");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			boardService.modArticle(articleMap);
			if (imageFileName != null && imageFileName.length() != 0) {
				File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
				File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO);
				FileUtils.moveFileToDirectory(srcFile, destDir, true);

				String originalFileName = (String) articleMap.get("originalFileName");
				File oldFile = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO + "\\" + originalFileName);
				oldFile.delete();
			}
			message = "<script>";
			message += " alert('글이 수정됨')";
			message += " location.href='" + multipartRequest.getContextPath() + "/board/viewArticle.do?articleNO="
					+ articleNO + "';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
			srcFile.delete();
			message = "<script>";
			message += " alert('글이 제대로 수정되지 않음')";
			message += " location.href='" + multipartRequest.getContextPath() + "/board/viewArticle.do?articleNO="
					+ articleNO + "';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}
		return resEnt;
	}

	// 글 삭제
	@Override
	@RequestMapping(value = "/board/removeArticle.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity removeArticle(@RequestParam("articleNO") int articleNO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			boardService.removeArticle(articleNO);
			File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO);
			FileUtils.deleteDirectory(destDir);

			message = "<script>";
			message += " alert('글이 삭제됨')";
			message += " location.href='" + request.getContextPath() + "/board/listArticles.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		} catch (Exception e) {
			message = "<script>";
			message += " alert('글이 제대로 삭제되지 않음')";
			message += " location.href='" + request.getContextPath() + "/board/listArticles.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}

	/*
	 * //���� �̹��� �� �߰��ϱ�
	 * 
	 * @Override
	 * 
	 * @RequestMapping(value="/board/addNewArticle.do" ,method = RequestMethod.POST)
	 * 
	 * @ResponseBody public ResponseEntity addNewArticle(MultipartHttpServletRequest
	 * multipartRequest, HttpServletResponse response) throws Exception {
	 * multipartRequest.setCharacterEncoding("utf-8"); String imageFileName=null;
	 * 
	 * Map articleMap = new HashMap(); Enumeration
	 * enu=multipartRequest.getParameterNames(); while(enu.hasMoreElements()){
	 * String name=(String)enu.nextElement(); String
	 * value=multipartRequest.getParameter(name); articleMap.put(name,value); }
	 * 
	 * //�α��� �� ���ǿ� ����� ȸ�� �������� �۾��� ���̵� ���ͼ� Map�� �����մϴ�.
	 * HttpSession session = multipartRequest.getSession(); MemberVO memberVO =
	 * (MemberVO) session.getAttribute("member"); String id = memberVO.getId();
	 * articleMap.put("id",id); articleMap.put("parentNO", 0);
	 * 
	 * List<String> fileList =upload(multipartRequest); List<ImageVO> imageFileList
	 * = new ArrayList<ImageVO>(); if(fileList!= null && fileList.size()!=0) {
	 * for(String fileName : fileList) { ImageVO imageVO = new ImageVO();
	 * imageVO.setImageFileName(fileName); imageFileList.add(imageVO); }
	 * articleMap.put("imageFileList", imageFileList); } String message;
	 * ResponseEntity resEnt=null; HttpHeaders responseHeaders = new HttpHeaders();
	 * responseHeaders.add("Content-Type", "text/html; charset=utf-8"); try { int
	 * articleNO = boardService.addNewArticle(articleMap); if(imageFileList!=null &&
	 * imageFileList.size()!=0) { for(ImageVO imageVO:imageFileList) { imageFileName
	 * = imageVO.getImageFileName(); File srcFile = new
	 * File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName); File destDir = new
	 * File(ARTICLE_IMAGE_REPO+"\\"+articleNO); //destDir.mkdirs();
	 * FileUtils.moveFileToDirectory(srcFile, destDir,true); } }
	 * 
	 * message = "<script>"; message += " alert('������ �߰��߽��ϴ�.');"; message +=
	 * " location.href='"+multipartRequest.getContextPath()
	 * +"/board/listArticles.do'; "; message +=" </script>"; resEnt = new
	 * ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	 * 
	 * 
	 * }catch(Exception e) { if(imageFileList!=null && imageFileList.size()!=0) {
	 * for(ImageVO imageVO:imageFileList) { imageFileName =
	 * imageVO.getImageFileName(); File srcFile = new
	 * File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName); srcFile.delete(); }
	 * }
	 * 
	 * 
	 * message = " <script>"; message
	 * +=" alert('������ �߻��߽��ϴ�. �ٽ� �õ��� �ּ���');');"; message
	 * +=" location.href='"+multipartRequest.getContextPath()
	 * +"/board/articleForm.do'; "; message +=" </script>"; resEnt = new
	 * ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	 * e.printStackTrace(); } return resEnt; }
	 * 
	 */

	@RequestMapping(value = "/board/*Form.do", method = RequestMethod.GET)
	private ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	// �Ѱ� �̹��� ���ε��ϱ�
	private String upload(MultipartHttpServletRequest multipartRequest) throws Exception {
		String imageFileName = null;
		Iterator<String> fileNames = multipartRequest.getFileNames();

		while (fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			imageFileName = mFile.getOriginalFilename();
			File file = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + fileName);
			if (mFile.getSize() != 0) { // File Null Check
				if (!file.exists()) { // ��λ� ������ �������� ���� ���
					file.getParentFile().mkdirs(); // ��ο� �ش��ϴ� ���丮���� ����
					mFile.transferTo(new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName)); // �ӽ÷� �����
																											// multipartFile��
																											// ����
																											// ���Ϸ�
																											// ����
				}
			}

		}
		return imageFileName;
	}

	/*
	 * //���� �̹��� ���ε��ϱ� private List<String> upload(MultipartHttpServletRequest
	 * multipartRequest) throws Exception{ List<String> fileList= new
	 * ArrayList<String>(); Iterator<String> fileNames =
	 * multipartRequest.getFileNames(); while(fileNames.hasNext()){ String fileName
	 * = fileNames.next(); MultipartFile mFile = multipartRequest.getFile(fileName);
	 * String originalFileName=mFile.getOriginalFilename();
	 * fileList.add(originalFileName); File file = new File(ARTICLE_IMAGE_REPO
	 * +"\\"+"temp"+"\\" + fileName); if(mFile.getSize()!=0){ //File Null Check
	 * if(!file.exists()){ //��λ� ������ �������� ���� ���
	 * file.getParentFile().mkdirs(); //��ο� �ش��ϴ� ���丮���� ����
	 * mFile.transferTo(new File(ARTICLE_IMAGE_REPO
	 * +"\\"+"temp"+ "\\"+originalFileName)); //�ӽ÷� ����� multipartFile�� ����
	 * ���Ϸ� ���� } } } return fileList; }
	 */
}
