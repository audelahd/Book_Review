package com.myspring.pro30.book.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface BookController {
	
	public ModelAndView listBooks(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
	
	public ModelAndView viewBook(@RequestParam("booktitle") String booktitle,
			                        HttpServletRequest request, HttpServletResponse response) throws Exception;

}
