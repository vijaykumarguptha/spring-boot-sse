package com.selfstudy.sse.configuration;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public class RequestModel {
	
	String transId;
	
	SseEmitter sseEmitter;

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public SseEmitter getSseEmitter() {
		return sseEmitter;
	}

	public void setSseEmitter(SseEmitter sseEmitter) {
		this.sseEmitter = sseEmitter;
	}
	
	
	
	

}
