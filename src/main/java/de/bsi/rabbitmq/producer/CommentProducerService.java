package de.bsi.rabbitmq.producer;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.bsi.rabbitmq.Comment;
import de.bsi.rabbitmq.RabbitmqConfig;

@RestController
@Profile("producer")
public class CommentProducerService {

	@Autowired private RabbitTemplate rabbitTemplate;
	
	@GetMapping(path = "/comment/create",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Comment createComment() {
		var comment = Comment.builder()
				.message("New comment message created")
				.author("Elmar")
				.createdAt(LocalDateTime.now())
				.build();
		rabbitTemplate.convertAndSend(RabbitmqConfig.COMMENT_QUEUE, comment);
		return comment;
	}
	
	@GetMapping(path = "/text/create",
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String createText() {
		var text = "New simple text message created.";
		rabbitTemplate.convertAndSend(RabbitmqConfig.COMMENT_QUEUE, text);
		return text;
	}
}
