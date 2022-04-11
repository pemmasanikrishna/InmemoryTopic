package com.treebo.inmemorytopic.publisher;

import com.treebo.inmemorytopic.message.Message;
import com.treebo.inmemorytopic.topic.Topic;

public class GenericPublisher<T> implements Publisher<T> {

	private String name;
	private Topic<T> topic;

	public GenericPublisher(String name, Topic<T> topic) {

		this.name = name;
		this.topic = topic;

	}

	@Override
	public boolean publishMessage(Message<T> message) {

		try {
			topic.publishMessage(message);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
