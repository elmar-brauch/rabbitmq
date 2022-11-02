package de.bsi.rabbitmq;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;

	private String author;
	private String message;
	private LocalDateTime createdAt;
	
}
