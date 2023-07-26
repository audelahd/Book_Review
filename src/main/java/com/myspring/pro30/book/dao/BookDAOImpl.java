package com.myspring.pro30.book.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.pro30.book.vo.BookVO;

@Repository("bookDAO")
public class BookDAOImpl implements BookDAO {

	@Autowired 
	private SqlSession sqlSession;

	@Override
	public List selectAllBooksList() throws DataAccessException {
		List<BookVO> booksList = booksList = sqlSession.selectList("");
		return booksList;
	}

	@Override
	public BookVO selectBook(String booktitle) throws DataAccessException {
		return sqlSession.selectOne("", booktitle);
	}
	
	
}
