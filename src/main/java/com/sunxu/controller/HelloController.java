package com.sunxu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sunxu.aspect.Permission;
import com.sunxu.config.HelloSender;

@RestController
@RequestMapping("hello")
public class HelloController {

	@Autowired
	HelloSender helloSender;

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

}
