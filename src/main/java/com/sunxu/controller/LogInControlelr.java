package com.sunxu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sunxu.utils.JedisUtils;

@RestController
@RequestMapping("login")
public class LogInControlelr {

	@RequestMapping(value = "index", method = { RequestMethod.POST })
	public void loginIndex() {
	}
}
