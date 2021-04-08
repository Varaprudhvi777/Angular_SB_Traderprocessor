package com.trading.app.service;

@SuppressWarnings("hiding")
public interface KafkaTemplate<String, TradeMessage> {
	void sendDefault(String key, TradeMessage msg); 
}