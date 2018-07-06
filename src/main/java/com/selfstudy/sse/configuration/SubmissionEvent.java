package com.selfstudy.sse.configuration;

import java.io.Serializable;

import org.springframework.context.ApplicationEvent;

public class SubmissionEvent extends ApplicationEvent implements Serializable
{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -7118613076462756704L;

	public SubmissionEvent(Object source,String message) {
        super(source);
        this.message = message;
    }
 
    // getters and setters
 
 
    private final String message;

	public String getMessage() {
		return message;
	}

	
    
    
    
    
    
    
}