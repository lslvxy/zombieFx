package com.pz.util;

/**
 * Copyright (C)
 * FileName: UserBean.java
 * 用户
 * 
 * @author  ls
 * @Date    2012-2-6
 * @version 1.00 
 */
public class UserBean {
	private String userName;
	private int score;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public String toString(){
		return this.userName+"   "+ this.score;
	}

}
