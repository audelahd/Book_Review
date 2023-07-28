package com.myspring.pro30.book.service;

import java.util.List;

import com.myspring.pro30.book.vo.BookVO;

public interface BookService {
	
	public List<BookVO> listBooks() throws Exception;
	public BookVO viewBook (String booktitle) throws Exception; //ㄱ-ㅎ 순으로 배치
	
	public List<BookVO> listBooks(String genre) throws Exception; //장르별 검색
}
