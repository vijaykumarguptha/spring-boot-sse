package com.selfstudy.sse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.selfstudy.sse.configuration.ApplicationEventListener;
import com.selfstudy.sse.configuration.RequestModel;
import com.selfstudy.sse.task.SseTimeOutTask;

@RestController
public class SSEController {

	@Autowired
	private ApplicationEventListener applicationEventListener;

	@GetMapping(value = "/registerSSE")
	public ResponseEntity<SseEmitter> registerSSE(@RequestParam("requestId") String requestId) {

		SseEmitter sseEmitter = new SseEmitter(60000L);

		SseTimeOutTask outTask = new SseTimeOutTask(requestId);

		sseEmitter.onTimeout(outTask);

		RequestModel requestModel = new RequestModel();
		requestModel.setSseEmitter(sseEmitter);
		requestModel.setTransId(requestId);

		applicationEventListener.addSseEmitters(requestId, requestModel);

		ResponseEntity<SseEmitter> response = new ResponseEntity<SseEmitter>(sseEmitter, HttpStatus.ACCEPTED);

		return response;
	}

}
