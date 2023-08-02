package com.myspring.pro30.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.pro30.board.dao.BoardDAO;
import com.myspring.pro30.board.vo.ArticleVO;


@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl  implements BoardService{
	@Autowired
	BoardDAO boardDAO; //DAO로 넘겨야 하니까 하나 만들어준다
	
	
	//모든 후기 반환
	public List<ArticleVO> listArticles() throws Exception{
		List<ArticleVO> articlesList =  boardDAO.selectAllArticlesList();
        return articlesList;
	}
	
	//특정 책 후기 반환
	public List<ArticleVO> listArticles(String booktitle_)throws Exception{
		List<ArticleVO> articlesList = boardDAO.selectAllReviewList(booktitle_);
		return articlesList;
	}
	
	//후기 상세 페이지
	@Override
	public ArticleVO viewArticle(int articleNO) throws Exception {
		ArticleVO articleVO = boardDAO.selectArticle(articleNO);
		return articleVO;
	}
	
	//후기 추가
	@Override
	public int addNewArticle(Map articleMap) throws Exception{
		System.out.println("1");
		return boardDAO.insertNewArticle(articleMap);
	}

	//후기 수정
	@Override
	public void modArticle(Map articleMap) throws Exception {
		boardDAO.updateArticle(articleMap);
	}
	
	//후기 추천
	@Override
	public void RECOUP(int articleNO) throws Exception {
		boardDAO.updateReco(articleNO);
		
	}

	//후기 삭제
	@Override
	public void removeArticle(int articleNO) throws Exception {
		boardDAO.deleteArticle(articleNO);
	}
	

	
}
