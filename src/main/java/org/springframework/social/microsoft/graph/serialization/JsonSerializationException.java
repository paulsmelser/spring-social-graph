package org.springframework.social.microsoft.graph.serialization;

public class JsonSerializationException extends RuntimeException{

	public JsonSerializationException(Throwable cause) {
		super("An error occurred", cause);
	}
}
