package com.treebo.inmemorytopic.consumer;

import com.treebo.inmemorytopic.message.Message;
import com.treebo.inmemorytopic.topic.Topic;

public class ConsoleConsumer extends GenericConsumer<String> {

	public ConsoleConsumer(String name, Topic<String> topic) {
		super(name, topic);

	}

	@Override
	public void consume(Message<String> message) {

		System.out.printf("Publisher %s has published %s", message.getPublisher(), message.getContent());

	}

}
