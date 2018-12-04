package com.sunxu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sunxu.aspect.Permission;

@RestController
@RequestMapping("hello")
public class HelloController {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Permission("实打实发哈数据库和")
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(String name) {
		log.info(name);
		return name;
	}
}
