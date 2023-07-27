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
	
	
	
	@Override
	@RequestMapping(value="/book/listBooks.do", method= {RequestMethod.GET,RequestMethod.POST} )
	public ModelAndView listBooks(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List booksList = bookService.listBooks();
		ModelAndView mav = new ModelAndView (viewName);
		mav.addObject("booksList", booksList);
		return mav;
	}

	@RequestMapping(value="/book/viewBook.do", method=RequestMethod.GET)
	public ModelAndView viewBook(@RequestParam("booktitle") String booktitle, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("잘들어옴1");
		String viewName = (String) request.getAttribute("viewName");
		System.out.println("잘들어옴2");
		bookVO = bookService.viewBook(booktitle);
		System.out.println("잘들어옴3");
		ModelAndView mav = new ModelAndView ();
		System.out.println("잘들어옴4");
		mav.setViewName(viewName);
		System.out.println("잘들어옴5");
		mav.addObject("book", bookVO);
		System.out.println("잘들어옴6");
		return mav;
	}

	
	
}
