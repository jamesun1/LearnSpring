package com.sunxu.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello") // 监听 名称为 hello 的queue
public class HelloReceiver {

	// 消息处理器
	@RabbitHandler
	public void process(String message) {
		System.out.println("Receiver:" + message);

	}
}
