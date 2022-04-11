package com.treebo.inmemorytopic.message;

import java.time.LocalDateTime;

import com.treebo.inmemorytopic.publisher.Publisher;

public class Message<T> {

	private T content;

	private Publisher<T> publisher;

	private LocalDateTime publishedAt = LocalDateTime.now();

	private String checksum;

	public Message(T content, Publisher<T> publisher) {

		this.publisher = publisher;
		this.content = content;

		this.checksum = String.valueOf(hashCode());
	}

	public T getContent() {
		return content;
	}

	public LocalDateTime getPublishedAt() {
		return publishedAt;
	}

	public String getChecksum() {
		return checksum;
	}

	public Publisher<T> getPublisher() {
		return publisher;
	}

	@Override
	public String toString() {
		return this.content.toString();
	}

}
