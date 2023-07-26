package com.myspring.pro30.book.vo;


import org.springframework.stereotype.Component;

@Component("BookVO")
public class BookVO {

	private String booktitle;
	private String writer;
	private String genre;
	
	
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	

}
