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
		return booksList;
	}

	@Override
	public BookVO viewBook(String booktitle) throws Exception {
		BookVO bookVO = bookDAO.selectBook(booktitle);
		System.out.println("service 들어옴");
		return bookVO;
	}
	
	

}
