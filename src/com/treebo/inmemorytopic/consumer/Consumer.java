package com.treebo.inmemorytopic.consumer;

import com.treebo.inmemorytopic.message.Message;

public interface Consumer<T> {
	
	String getName();
	
	void consume(Message<T> message);
	
	boolean startConsuming();
	
	boolean stopConsuming();

}
