package com.selfstudy.sse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication(scanBasePackages="com.selfstudy.sse")
@EnableJms
public class SSEApplication {

	public static void main(String[] args) {

		SpringApplication.run(SSEApplication.class, args);

	}

}
