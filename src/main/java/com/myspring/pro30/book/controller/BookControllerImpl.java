package com.myspring.pro30.book.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@Override
	@RequestMapping(value="/book/viewBook.do", method=RequestMethod.GET)
	public ModelAndView viewArticle(String booktitle, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		bookVO = bookService.viewBook(booktitle);
		ModelAndView mav = new ModelAndView ();
		mav.setViewName(viewName);
		mav.addObject("book", bookVO);
		return mav;
	}

	
	
}
