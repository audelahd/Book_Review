package com.myspring.pro30.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.pro30.book.dao.BookDAO;
import com.myspring.pro30.book.vo.BookVO;

@Service("bookService")
@Transactional(propagation=Propagation.REQUIRED)
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookDAO bookDAO;

	@Override
	public List<BookVO> listBooks() throws Exception {
		List<BookVO> booksList = bookDAO.selectAllBooksList(); 
		//DAO의 모든 책 리스트 조회 메소드로 넘긴다
		return booksList;
	}

	@Override
	public BookVO viewBook(String booktitle) throws Exception {
		BookVO bookVO = bookDAO.selectBook(booktitle);
		//DAO의 책 상세 조회 메소드로 넘긴다. (책 제목과 함께)
		return bookVO;
	}

	@Override
	public List<BookVO> listBooks(String genre) throws Exception {
		List<BookVO> booksList = bookDAO.selectAllGenreList(genre);
		//DAO의 리스트 조회 메소드로 넘긴다 (책 장르와 함께)
		return booksList;
	}
	
	

}
