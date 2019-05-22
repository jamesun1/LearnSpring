package com.sunxu.component;

import java.util.concurrent.Future;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class Hello {
	@Async
	public Future<String> sayHello1(String name) {
		String res = name + ":Hello World!";
		LoggerFactory.getLogger(Hello.class).info(res + "调用1成功");
		return new AsyncResult<>(res);
	}

	@Async
	public Future<String> sayHello2(String name) {
		String res = name + ":Hello World!";
		LoggerFactory.getLogger(Hello.class).info(res + "调用2成功");
		return new AsyncResult<>(res);
	}
}