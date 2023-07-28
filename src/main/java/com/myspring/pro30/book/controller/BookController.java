package com.myspring.pro30.book.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface BookController {
	
	//전체 리스트
	public ModelAndView listBooks(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
	//책 상세
	public ModelAndView viewBook(@RequestParam("booktitle") String booktitle,
			                        HttpServletRequest request, HttpServletResponse response) throws Exception;

	
	//장르별 리스트 
	public ModelAndView listBooks(@RequestParam("genre") String genre, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
