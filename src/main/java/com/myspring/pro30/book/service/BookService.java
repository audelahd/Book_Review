package com.myspring.pro30.book.service;

import java.util.List;

import com.myspring.pro30.book.vo.BookVO;

public interface BookService {
	
	public List<BookVO> listBooks() throws Exception; //전체 책 리스트
	public BookVO viewBook (String booktitle) throws Exception; //책 정보 조회
	public List<BookVO> listBooks(String genre) throws Exception; //장르별 검색
}
