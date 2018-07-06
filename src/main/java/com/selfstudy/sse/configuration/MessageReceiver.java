package com.selfstudy.sse.configuration;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jms.JmsException;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageReceiver implements MessageListener {
	
    /**
     * New feature in Spring 4.2.
     */
    @Autowired
    private  ApplicationEventPublisher eventPublisher;
	
	
	
	
    /* (non-Javadoc)
     * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
     */
    public void onMessage(Message message) {
    	
    	
    	log.info(" ==>> "+message);
    	
    	String event=null;
    	String submissionId =null;
        if ( message instanceof TextMessage ) {
            final TextMessage mapMessage = (TextMessage) message;
            String messageText="";
            try {
                try {
                	messageText=mapMessage.getText();
                	eventPublisher.publishEvent(new SubmissionEvent(this,messageText));
				} catch (Exception e) {
					System.out.println(" ==>> "+e.getMessage());
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

                
                
                
                
            } catch (JmsException ex) {
               
            } 
        }
    }
 

}