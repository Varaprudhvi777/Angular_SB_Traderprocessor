package com.trading.app.service;

import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.trading.app.model.TradeMessage;

@Service
public class KafkaTemplateImpl implements KafkaTemplate<String, TradeMessage>{

	
	org.springframework.kafka.core.KafkaTemplate<String, String> kafkaTemplate;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public KafkaTemplateImpl(ProducerFactory<String , TradeMessage> producerFactory) {
		kafkaTemplate = new org.springframework.kafka.core.KafkaTemplate(producerFactory);
	}
	
	
	public void sendDefault(String key, TradeMessage msg) {
		String data = new Gson().toJson(msg);
		kafkaTemplate.send(key, data);
	}

}
