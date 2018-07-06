package com.selfstudy.sse.configuration;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ApplicationEventListener implements ApplicationListener<SubmissionEvent> {

	public void addSseEmitters(String submissionId, RequestModel requestModel) {
		sseEmitters.put(submissionId, requestModel);
	}

	
	public void removeSseEmitters(String submissionId) {
		sseEmitters.remove(submissionId);
	}
	/**
	 * The list of the objects of SseEmitter. The key of the map stands for
	 * submissionId. The value of the map is the corresponding SseEmitter object.
	 */
	private static Map<String, RequestModel> sseEmitters = new ConcurrentHashMap();

	public void onApplicationEvent(SubmissionEvent arg0) {

		log.info(" ---- ApplicationEventListener" + " arg0 " + arg0.getMessage());
		try {
			sseEmitters.get(arg0.getMessage()).getSseEmitter().send("cesssuc");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}
}