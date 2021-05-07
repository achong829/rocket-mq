package com.example.rocketmqproducer.service;

import io.swagger.annotations.ApiModelProperty;

public interface RocketMq01Service {



	@ApiModelProperty("新增银行卡--新增接口")
	String simpleTest() throws Exception;

	@ApiModelProperty("新增银行卡--基本样例")
	String basicDemo() throws Exception;



}
