package com.myspring.pro30.board.service;

import java.util.List;
import java.util.Map;

import com.myspring.pro30.board.vo.ArticleVO;

public interface BoardService {
	public List<ArticleVO> listArticles() throws Exception; //조건X, 모든 후기의 리스트를 반환함
	public List<ArticleVO> listArticles(String booktitle_) throws Exception; //특정 책의 후기 리스트를 반환함
	public int addNewArticle(Map articleMap) throws Exception; //새 후기를 추가함
	public void RECOUP(int articleNO) throws Exception; //후기에 추천을 함
	public ArticleVO viewArticle(int articleNO) throws Exception; //후기의 상세 페이지를 조회함
	public void modArticle(Map articleMap) throws Exception; //후기를 수정함
	public void removeArticle(int articleNO) throws Exception; //후기를 삭제함
}
