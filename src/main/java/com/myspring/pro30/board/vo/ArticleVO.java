package com.myspring.pro30.board.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("articleVO")
public class ArticleVO {
	private int level; // 글 레벨
	private int articleNO; // 글 번호
	private int parentNO; // 의견
	private float staring; // 별점
	private int booknum;
	private String booktitle; // 책 제목
	private String booktitle_; // 책 제목
	private String content; // 리뷰 내용
	private String imageFileName; // 이미지 파일
	private String id; // 작성자
	private Date writeDate; // 작성일
	private int reco;
	
	
	
	
	public int getReco() {
		return reco;
	}

	public void setReco(int reco) {
		this.reco = reco;
	}

	public String getBooktitle_() {
		return booktitle_;
	}

	public void setBooktitle_(String booktitle_) {
		this.booktitle_ = booktitle_;
	}

	public int getBooknum() {
		return booknum;
	}

	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}

	public ArticleVO() {
		System.out.println("ArticleVO");
	}

	public int getArticleNO() {
		return articleNO;
	}

	public void setArticleNO(int articleNO) {
		this.articleNO = articleNO;
	}

	public int getParentNO() {
		return parentNO;
	}

	public void setParentNO(int parentNO) {
		this.parentNO = parentNO;
	}

	public String getStaring() { //별점을 불러올 때 별 아이콘으로 불러온다.

		String result = "";

		if (staring != 0.0f) {
			double starnum1 = staring % 1.0;
			double starnum2 = staring / 1.0;

			if (starnum1 == 0.5) {
				for (int i = 0; i < starnum2 - 1; i++) {
					result += "★";
				}
				result += "☆";
			} else {
				for (int i = 0; i < starnum2; i++) {
					result += "★";
				}
			}
		}

		System.out.println(result);
		return result;
	}

	public void setStaring(float staring) {
		this.staring = staring;
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageFileName() {
		try {
			if (imageFileName != null && imageFileName.length() != 0) {
				imageFileName = URLDecoder.decode(imageFileName, "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		try {
			if (imageFileName != null && imageFileName.length() != 0) {
				this.imageFileName = URLEncoder.encode(imageFileName, "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

}
