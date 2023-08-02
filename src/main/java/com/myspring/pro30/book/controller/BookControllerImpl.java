package com.myspring.pro30.book.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.pro30.book.service.BookService;
import com.myspring.pro30.book.vo.BookVO;


@Controller("bookController")
public class BookControllerImpl implements BookController{

	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookVO bookVO;
	
	
	//전체 책 리스트 출력
	@Override // book/listBooks.do일때 실행된다
	@RequestMapping(value="/book/listBooks.do", method= {RequestMethod.GET,RequestMethod.POST} )
	public ModelAndView listBooks(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List booksList = bookService.listBooks();
		ModelAndView mav = new ModelAndView (viewName);
		mav.addObject("booksList", booksList); //조회한 데이터를 mav에 set하고 보여준다.
		return mav;
	}
	
	//책 상세 페이지 출력
	// book/viewBook.do일때 실행된다
	@RequestMapping(value="/book/viewBook.do", method=RequestMethod.GET)
	public ModelAndView viewBook(@RequestParam("booktitle") String booktitle, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//booktitle을 받아와 책 제목 기준으로 정보를 가져온다.
		String viewName = (String) request.getAttribute("viewName");
		bookVO = bookService.viewBook(booktitle); //bookService의 책 조회하는 메소드 호출
		ModelAndView mav = new ModelAndView ();
		mav.setViewName(viewName);
		mav.addObject("book", bookVO); //조회한 데이터를 mav에 set하고 보여준다.
		return mav;
	}

	//책 장르별 리스트 출력
	@Override // book/genreSearch.do일때 실행된다
	@RequestMapping(value="/book/genreSearch.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listBooks(@RequestParam("genre") String genre, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//genre를 받아와 특정 장르의 책만 리스트로 만들어 반환한다.
		String viewName = (String) request.getAttribute("viewName");
		List booksList = bookService.listBooks(genre);
		ModelAndView mav = new ModelAndView (viewName);
		mav.addObject("booksList", booksList); //반환한 리스트를 mav에 set하고 보여줌
		return mav;
	}

	
	
}
