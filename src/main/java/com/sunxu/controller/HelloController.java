package com.sunxu.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sunxu.aspect.Permission;
import com.sunxu.component.Hello;
import com.sunxu.config.HelloSender;

@RestController
@RequestMapping("hello")
public class HelloController {

	@Autowired
	HelloSender helloSender;
	@Autowired
	private Hello hello;

	Logger log = LoggerFactory.getLogger(getClass());

	@Permission("实打实发哈数据库和")
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(String name) {
		log.info(name);
		return name;
	}

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String hello(String name) {
		helloSender.send(name);
		return name;
	}

	@RequestMapping(value = "example", method = RequestMethod.GET)
	public String example(String name) {
		helloSender.send(name);
		return name;
	}

	@RequestMapping(value = "sayHello", method = RequestMethod.GET)
	public String sayHello(String name) throws InterruptedException {
		Future<String> task1 = hello.sayHello1("yan");
		Future<String> task2 = hello.sayHello2("yan");

		for (;;) {
			if (task1.isDone() && task2.isDone()) {
				// 三个任务都调用完成，退出循环等待
				break;
			}
		}
		LoggerFactory.getLogger(HelloController.class).info("调用成功");
		return "已完成";
	}
}
