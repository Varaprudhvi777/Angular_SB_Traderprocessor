package com.trading.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trading.app.model.Message;
import com.trading.app.service.TradeProcessor;

@RestController
@RequestMapping(value="/trade")
public class TradeProcessorController {

	@Autowired
	TradeProcessor tradeProcessor;
	
	@PostMapping(value="/tradeMessage")
	public String processMsg(@RequestBody String msgStr) {
		Message message = new Message();
		message.messageString=msgStr;
		tradeProcessor.onMessage(message);
		return "success";
	}
	
	
}
