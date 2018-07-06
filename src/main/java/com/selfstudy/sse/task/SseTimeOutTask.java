package com.selfstudy.sse.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.selfstudy.sse.configuration.ApplicationEventListener;

@Component
public class SseTimeOutTask  implements Runnable{
	
	
	private String submissionId;
	
	
	public SseTimeOutTask(String submissionId) {
		this.submissionId=submissionId;
	}
	
	
	@Autowired
	private ApplicationEventListener applicationEventListener;

	@Override
	public void run() {
		applicationEventListener.removeSseEmitters(submissionId);
	}

}
