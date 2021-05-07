package com.example.rocketmqproducer.controller;

import com.example.rocketmqproducer.service.RocketMq01Service;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RocketMq01Controller {

	@Autowired
	private RocketMq01Service rocketMq01Service;

	@ApiModelProperty("rocket mq 01")
	@RequestMapping(value = "/rocket-mq-01/simple-test")
	public String simpleTest() throws Exception {
		return rocketMq01Service.simpleTest();
	}

	@ApiModelProperty("rocket mq 02")
	@RequestMapping(value = "/rocket-mq-02/simple-test")
	public String basicDemo() throws Exception {
		return rocketMq01Service.basicDemo();
	}


}
