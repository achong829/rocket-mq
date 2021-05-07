package com.example.rocketmqproducer.service.impl;

import com.example.rocketmqproducer.service.RocketMq01Service;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.apache.rocketmq.spring.support.RocketMQUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.messaging.Message;

@Slf4j
@Service
public class RocketMq01ServiceImpl implements RocketMq01Service {

	@Autowired
	private RocketMQTemplate rocketMQTemplate;


	@Override
	public String simpleTest() throws Exception {
		rocketMQTemplate.convertAndSend("TopicTest", "2222222");
		return null;
	}

	@Override
	public String basicDemo() throws Exception {
		Message message = MessageBuilder.withPayload("hahahaha").setHeader(RocketMQHeaders.TAGS, "TagA").build();
		log.info("message.getPayload()========>{}", message.getPayload());
		log.info("message.getHeaders()========>{}", message.getHeaders());
		String destination ="wuchongTest:TagB";
		log.info("message========>{}", message);
		rocketMQTemplate.send(destination, message);
		org.apache.rocketmq.common.message.Message message1 = RocketMQUtil.convertToRocketMessage(new StringMessageConverter(),"UTF-8",destination, message);
		log.info("message1========>{}", message1);
		return null;
	}
}
