package de.bsi.rabbitmq;

import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.SmartMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class RabbitmqConfig {
	
	public static final String COMMENT_QUEUE = "comments";
	
	@Bean
	@Profile("producer")
	RabbitAdmin createRabbitAdminAndInitQueue(RabbitTemplate rabbitTemplate) {
		var admin = new RabbitAdmin(rabbitTemplate);
		if (admin.getQueueInfo(COMMENT_QUEUE) != null)
			admin.purgeQueue(COMMENT_QUEUE);
		else
			admin.declareQueue(QueueBuilder.durable(COMMENT_QUEUE).build());
		return admin;
	}
	
	@Bean
	SmartMessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter(objectMapper());
	}
	
	@Bean
    ObjectMapper objectMapper() {
        var mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }
	
}
