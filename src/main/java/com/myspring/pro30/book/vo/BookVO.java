package com.myspring.pro30.book.vo;


import org.springframework.stereotype.Component;

@Component("bookVO")
public class BookVO {

	private String booktitle;
	private String bookwriter;
	private String genre;
	private String bookinfo;
	
	
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getBookwriter() {
		return bookwriter;
	}
	public void setBookwriter(String bookwriter) {
		this.bookwriter = bookwriter;
	}


	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getBookinfo() {
		return bookinfo;
	}
	public void setBookinfo(String bookinfo) {
		this.bookinfo = bookinfo;
	}
	
	
	

}
