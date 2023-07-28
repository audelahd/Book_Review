package com.myspring.pro30.book.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.pro30.book.vo.BookVO;


public interface BookDAO {
	public List selectAllBooksList() throws DataAccessException;
	public BookVO selectBook (String booktitle) throws DataAccessException;
	
	public List selectAllGenreList(String genre) throws DataAccessException;
}
