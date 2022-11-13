package de.bsi.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import de.bsi.rabbitmq.Comment;
import de.bsi.rabbitmq.RabbitmqConfig;
import lombok.extern.slf4j.Slf4j;

@RabbitListener(queues = RabbitmqConfig.COMMENT_QUEUE)
@Component
@Slf4j
@Profile("consumer")
public class CommentConsumerService {
	
	@RabbitHandler
	public void readComments(Comment comment) {
		log.info(comment.toString());
	}
	
	@RabbitHandler
	public void readComments(String text) {
		log.info(text);
	}
}
