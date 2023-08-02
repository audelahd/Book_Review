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
		//모든 책들을 리스트로 반환하는 SQL문을 실행한다
		return booksList;
	}

	@Override
	public BookVO selectBook(String booktitle) throws DataAccessException {
		//책 상세페이지를 조회하는 SQL문을 실행한다
		return sqlSession.selectOne("mapper.book.selectBook", booktitle);
	}

	@Override
	public List selectAllGenreList(String genre) throws DataAccessException {
		List<BookVO> booksList = booksList = sqlSession.selectList("mapper.book.selectAllGenreList", genre);
		//특정 장르의 책들을 리스트로 반환하는 SQL문을 실행한다
		return booksList;
	}
	
	
	
	
}
