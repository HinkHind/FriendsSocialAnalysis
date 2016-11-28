package com.tieba.spider;

import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

public class Iterm implements HtmlBean{

	private static final long serialVersionUID = 7986688770891039999L;
	
	@Text
	@HtmlField(cssPath="#j_core_title_wrap > div.core_title.core_title_theme_bright > h1")
	private String title;
	
	@Text
	@HtmlField(cssPath="div.d_author > ul > li.d_name > a")
	private String author;
	
	@Text
	@HtmlField(cssPath="cc > div")
	private String content;

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getContent() {
		return content;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	

}
