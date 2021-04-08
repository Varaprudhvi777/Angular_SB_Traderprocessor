package com.trading.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.trading.app.model.Message;
import com.trading.app.model.TradeMessage;

@Service
public class TradeProcessor {


	@Autowired
	RestTemplate restTemplate;

	@Autowired
	KafkaTemplateImpl kafkaTemplateBean;

	@Value("${kafka.topic}")
	String topic;

	@Value("${kafka.group}")
	String groupId;

	
	@Autowired
	private SimpMessagingTemplate webSocket;

	public static final String WEBSOCKET_DESTINATION = "/topic/messages";

	public void onMessage(Message msg) {
		TradeMessage tradeMessage= new TradeMessage();
		tradeMessage.setAccount(msg.getString(1));
		tradeMessage.setPrice(msg.getDouble(6));
		tradeMessage.setQty(msg.getInt(32));
		tradeMessage.setSecurityId(msg.getString(48));
		tradeMessage.setTradeId(msg.getString(17));
		/*		ResponseEntity<SecurityId> responsEntity = restTemplate.postForEntity("", "{\"SecurityId\":\"48\"}", SecurityId.class);
		SecurityId securityId=responsEntity.getBody();
		tradeMessage.setCusip(securityId.getCusip());
		tradeMessage.setIsin(securityId.getIsin());
		tradeMessage.setRic(securityId.getRic());
		tradeMessage.setSedol(securityId.getSedol());
		tradeMessage.setTicker(securityId.getTicker());*/

		kafkaTemplateBean.sendDefault(topic, tradeMessage);

	}


	@KafkaListener(topics= "${kafka.topic}")
	public void consumeKafkaMsg(@Payload String msg) {
		this.webSocket.convertAndSend(WEBSOCKET_DESTINATION, msg);
	}

}