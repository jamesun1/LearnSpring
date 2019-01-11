package com.sunxu.config;

import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sunxu.dao.UserInfoMapper;
import com.sunxu.entity.UserInfo;

@Component
public class HelloReceiver {

	@Autowired
	private UserInfoMapper userInfoMapper;

	// 消息处理器
	@RabbitHandler
	// 监听 名称为 hello 的queue
	@RabbitListener(queues = "hello")
	public void process(String message) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				UserInfo userInfo = new UserInfo();
				userInfo.setUserId(UUID.randomUUID().toString());
				userInfo.setUserPassword("132456");
				userInfo.setName(message);
				userInfoMapper.insert(userInfo);
				System.out.println("Receiver:" + message);
			}
		}, 1000*5);

	}
}
