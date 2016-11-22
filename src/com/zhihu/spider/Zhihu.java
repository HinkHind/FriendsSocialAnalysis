package com.zhihu.spider;

public class Zhihu {
	private String question; //问题
	private String answer; //回答
	private String questionUrl; //问题原地址
	private int likeNum; //回答赞数
	private String answerTime; //回答时间
	public String getQuestion() {
		return question;
	}
	public String getQuestionUrl() {
		return questionUrl;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getLikeNum() {
		return likeNum;
	}
	public String getAnswerTime() {
		return answerTime;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public void setQuestionUrl(String questionUrl) {
		this.questionUrl = questionUrl;
	}
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	public void setAnswerTime(String answerTime) {
		this.answerTime = answerTime;
	}
}
