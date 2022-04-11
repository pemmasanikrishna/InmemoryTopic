package com.treebo.inmemorytopic.topic;

public class TopicFactory<T> {

	public Topic<T> createTopic(TopicConfiguration configuration) {

		Topic<T> topic = new GenericTopic<>(configuration.getName());

		return topic;

	}

}
