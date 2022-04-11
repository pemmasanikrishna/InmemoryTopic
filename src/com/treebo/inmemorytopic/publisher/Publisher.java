package com.treebo.inmemorytopic.publisher;

import com.treebo.inmemorytopic.message.Message;

public interface Publisher<T> {
	
	boolean publishMessage(Message<T> message);
	
	String getName();

}
