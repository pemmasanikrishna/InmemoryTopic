package com.treebo.inmemorytopic.consumer;

import com.treebo.inmemorytopic.message.Message;
import com.treebo.inmemorytopic.topic.Topic;

public abstract class GenericConsumer<T> implements Consumer<T> {

	private String name;
	private Topic<T> topic;

	private volatile boolean shouldConsume = false;

	private int lastReadLocation;

	public GenericConsumer(String name, Topic<T> topic) {
		this.name = name;
		this.topic = topic;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean startConsuming() {

		try {

			this.shouldConsume = true;

			synchronized (this) {
				while (shouldConsume) {
					Message<T> message = topic.getMessageAt(lastReadLocation);
					if (message != null) {
						consume(message);
						lastReadLocation++;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public synchronized boolean stopConsuming() {

		this.shouldConsume = false;
		return true;
	}

}
