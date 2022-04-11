package com.treebo.inmemorytopic.topic;

import java.util.List;

import com.treebo.inmemorytopic.consumer.Consumer;
import com.treebo.inmemorytopic.message.Message;

public interface Topic<T> {
	
	boolean subscribe(Consumer<T> consumer);
	
	boolean unSubscribe(Consumer<T> consumer);
	
	List<Consumer<T>> getConsumers();

	Message<T> getMessageAt(int i);

	void publishMessage(Message<T> message);
	
	String getName();

}
