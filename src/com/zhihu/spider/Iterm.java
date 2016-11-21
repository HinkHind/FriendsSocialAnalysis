package com.zhihu.spider;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;
import com.google.common.annotations.VisibleForTesting;

public class Iterm implements HtmlBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3538962939917540023L;


	@Text
	@HtmlField(cssPath="h2 a")
	private String question; //问题
	
	@Href
	@HtmlField(cssPath="h2 a")
	private String questionUrl; //问题地址

	@Text
	@HtmlField(cssPath="div > div > div.zm-item-rich-text.expandable.js-collapse-body > textarea")
	private String answer; //回答内容
	
	@Text
	@HtmlField(cssPath="div.zm-item-vote a")
	private int like; //回答赞数

	@Text
	@HtmlField(cssPath="div > div > div.zm-item-rich-text.expandable.js-collapse-body > p > a")
	private String answerTime;
	
	public String getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(String answerTime) {
		this.answerTime = answerTime;
	}

	public String getAnswer() {
		return answer;
	}

	public int getLike() {
		return like;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setLike(int like) {
		this.like = like;
	}
	public String getQuestion() {
		return question;
	}

	public String getQuestionUrl() {
		return questionUrl;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setQuestionUrl(String questionUrl) {
		this.questionUrl = questionUrl;
	}
	

}
