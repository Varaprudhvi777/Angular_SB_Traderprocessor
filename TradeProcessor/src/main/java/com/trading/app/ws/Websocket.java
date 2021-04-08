package com.trading.app.ws;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import com.trading.app.service.KafkaTemplate;
import com.trading.app.model.TradeMessage;
import com.trading.app.service.KafkaTemplateImpl;

@Configuration
@EnableWebSocketMessageBroker
public class Websocket implements WebSocketMessageBrokerConfigurer {

	@Value("${kafka.producer.bootstrap-servers}")
	public String bootstrapServers; 

	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.setApplicationDestinationPrefixes("/app");
		config.enableSimpleBroker("/topic");
	}

	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/websocket").setAllowedOrigins("*");
	}
	
	public ProducerFactory<String , TradeMessage> producerFactory(){
		Map<String,Object> producerConfigProperties= new HashMap<String,Object>();
		producerConfigProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		producerConfigProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerConfigProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return new DefaultKafkaProducerFactory<String, TradeMessage>(producerConfigProperties);
	}

	@Bean(name="kafkaTemplateBean")
	public KafkaTemplate<String, TradeMessage> kafkaTemplate() {
		return new KafkaTemplateImpl(producerFactory());
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}