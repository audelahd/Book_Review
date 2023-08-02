package com.myspring.pro30.book.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.pro30.book.vo.BookVO;


public interface BookDAO {
	public List selectAllBooksList() throws DataAccessException; //모든 책 조회
	public BookVO selectBook (String booktitle) throws DataAccessException; //책 상세 정보 조회 
	public List selectAllGenreList(String genre) throws DataAccessException; //장르별 책 조회
}
