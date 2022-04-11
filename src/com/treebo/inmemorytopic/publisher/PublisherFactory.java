package com.treebo.inmemorytopic.publisher;

import com.treebo.inmemorytopic.topic.Topic;

public class PublisherFactory<T> {

	public Publisher<T> createPublisher(String name, Topic<T> topic) {

		return new GenericPublisher<>(name, topic);

	}
}
