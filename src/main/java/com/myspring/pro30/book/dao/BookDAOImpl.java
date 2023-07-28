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
		List<BookVO> booksList = booksList = sqlSession.selectList("mapper.book.selectAllBooksList");
		return booksList;
	}

	@Override
	public BookVO selectBook(String booktitle) throws DataAccessException {
		System.out.println("DAO 들어옴");
		return sqlSession.selectOne("mapper.book.selectBook", booktitle);
	}

	@Override
	public List selectAllGenreList(String genre) throws DataAccessException {
		List<BookVO> booksList = booksList = sqlSession.selectList("mapper.book.selectAllGenreList", genre);
		return booksList;
	}
	
	
	
	
}
