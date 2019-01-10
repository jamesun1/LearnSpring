package com.sunxu.config;

import java.time.LocalDateTime;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void send(String data) {
		String context = "hello----" + LocalDateTime.now();
		System.out.println(data + "--send:" + context);
		// 往名称为 hello 的queue中发送消息
		this.amqpTemplate.convertAndSend("hello", context);
	}

}
