package com.myspring.pro30.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public interface BoardController { //후기 컨트롤러

	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception;
	//후기의 전체 리스트를 출력
	
	public ModelAndView listArticles(@RequestParam("booktitle_")String booktitle_, HttpServletRequest request, HttpServletResponse response) throws Exception;
	//특정 책의 후기 리스트를 출력
	
	public ResponseEntity addNewArticle(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception; //새 후기를 등록

	
	public ResponseEntity recoUp(@RequestParam("articleNO") int articleNO, HttpServletRequest request,
			HttpServletResponse response) throws Exception; //후기에 추천을

	public ModelAndView viewArticle(@RequestParam("articleNO") int articleNO, HttpServletRequest request,
			HttpServletResponse response) throws Exception; //후기의 상세 페이지 호출

	public ResponseEntity removeArticle(@RequestParam("articleNO") int articleNO, HttpServletRequest request,
			HttpServletResponse response) throws Exception; //후기 삭제

}
