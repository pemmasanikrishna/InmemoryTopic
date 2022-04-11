package com.treebo.inmemorytopic.topic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.treebo.inmemorytopic.consumer.Consumer;
import com.treebo.inmemorytopic.message.Message;

public class GenericTopic<T> implements Topic<T> {

	private Map<String, Consumer<T>> consumers = new HashMap<>();
	
	private Map<Integer, Message<T>> messages = new ConcurrentHashMap<>();
	
	private volatile int newMessagePosition = 0;
	
	private String name;
	
	public GenericTopic(String name) {

		this.name = name;
	
	}

	@Override
	public boolean subscribe(Consumer<T> consumer) {

		consumers.put(consumer.getName(), consumer);

		return true;
	}

	@Override
	public boolean unSubscribe(Consumer<T> consumer) {
		consumers.remove(consumer.getName());
		return true;
	}

	@Override
	public List<Consumer<T>> getConsumers() {
		return null;
	}

	@Override
	public Message<T> getMessageAt(int i) {
		
		return messages.get(i);
	}

	@Override
	public void publishMessage(Message<T> message) {
		
		synchronized (this) {
			this.messages.put(newMessagePosition++, message);
		}

	}

	@Override
	public String getName() {
		return name;
	}


}
