package com.myspring.pro30.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.pro30.board.vo.ArticleVO;


public interface BoardDAO {
	public List selectAllArticlesList() throws DataAccessException; //조건 X, 모든 후기 리스트 반환
	public List selectAllReviewList(String booktitle_)throws DataAccessException; //특정 책의 후기 리스트를 반환
	public int insertNewArticle(Map articleMap) throws DataAccessException; // 새 후기 작성
	public ArticleVO selectArticle(int articleNO) throws DataAccessException; //후기 조회
	public void updateReco(int articleNO) throws DataAccessException; // 후기 추천
	public void updateArticle(Map articleMap) throws DataAccessException; // 후기 수정
	public void deleteArticle(int articleNO) throws DataAccessException; // 후기 삭제 
	
}
