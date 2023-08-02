package com.myspring.pro30.board.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.pro30.board.vo.ArticleVO;
import com.myspring.pro30.board.vo.ImageVO;


@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession sqlSession; //SqlSession 하나 만들기 

	@Override
	public List selectAllArticlesList() throws DataAccessException {
		List<ArticleVO> articlesList = articlesList = sqlSession.selectList("mapper.board.selectAllArticlesList");
		//ArticleVO로 만들어진 리스트를 반환하는데, 리스트를 selectAllArticlesList가 아이디인 sql문을 실행해서 받아온다.
		return articlesList;
	}
	
	
	@Override
	public List selectAllReviewList(String booktitle_) throws DataAccessException {
		List<ArticleVO> articlesList = articlesList = sqlSession.selectList("mapper.board.selectAllReviewList", booktitle_);
		//ArticleVO로 만들어진 리스트를 반환하는데, 리스트를 selectAllReviewList가 아이디인 sql문을 실행해서 받아온다.
		return articlesList;
	}



	@Override 
	public int insertNewArticle(Map articleMap) throws DataAccessException {
		int articleNO = selectNewArticleNO(); //새 글 번호를 만든다 (겹치지 않도록)
		articleMap.put("articleNO", articleNO); //만든 번호를 Map에 넣음
		sqlSession.insert("mapper.board.insertNewArticle",articleMap); 
		//앞에서 계속 받아온 데이터와 합해서 sql문 실행
		return articleNO;
	}

	@Override
	public void updateReco(int articleNO) throws DataAccessException {
		sqlSession.update("mapper.board.recoUp", articleNO); 
		//후기 글 번호를 추천하는 sql문으로 넘긴다
	}


	@Override
	public ArticleVO selectArticle(int articleNO) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectArticle", articleNO); 
		//후기 글 번호를 조회 sql문으로 넘긴다
	}

	@Override
	public void updateArticle(Map articleMap) throws DataAccessException {
		sqlSession.update("mapper.board.updateArticle", articleMap);
		//수정한 데이터를 수정 sql문으로 넘긴다
	}

	@Override
	public void deleteArticle(int articleNO) throws DataAccessException {
		sqlSession.delete("mapper.board.deleteArticle", articleNO); 
		//후기 글 번호를 삭제 sql문으로 넘긴다
		
	}

	private int selectNewArticleNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNewArticleNO"); 
		//새 글 번호를 만든다.
		
	}



}
