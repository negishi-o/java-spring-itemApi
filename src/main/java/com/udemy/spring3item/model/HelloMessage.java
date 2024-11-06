package com.udemy.spring3item.model;

public class HelloMessage {

	private String srtMessage;

	public HelloMessage(String inMsg) {
		this.srtMessage = inMsg;
	}
	public String getSrtMessage() {
		return srtMessage;
	}

	public void setSrtMessage(String srtMessage) {
		this.srtMessage = srtMessage;
	}
	
}
