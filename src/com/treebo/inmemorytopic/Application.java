package com.treebo.inmemorytopic;

import com.treebo.inmemorytopic.consumer.ConsoleConsumer;
import com.treebo.inmemorytopic.message.Message;
import com.treebo.inmemorytopic.publisher.Publisher;
import com.treebo.inmemorytopic.publisher.PublisherFactory;
import com.treebo.inmemorytopic.topic.Topic;
import com.treebo.inmemorytopic.topic.TopicConfiguration;
import com.treebo.inmemorytopic.topic.TopicFactory;

public class Application {

	public static void main(String[] args) throws InterruptedException {

		TopicFactory<String> factory = new TopicFactory<String>();

		TopicConfiguration configuration = new TopicConfiguration("topic");
		Topic<String> topic1 = factory.createTopic(configuration);

		ConsoleConsumer consoleConsumer = new ConsoleConsumer("consumer 1", topic1);
		
		
		Thread consumerThread = new Thread(() -> {
			consoleConsumer.startConsuming();
		});
		
		consumerThread.start();

		PublisherFactory<String> publisherFactory = new PublisherFactory<String>();
		Publisher<String> p1 = publisherFactory.createPublisher("p1", topic1);
		
		
		
		Message<String> message = new Message<>("m1", p1);
		
		p1.publishMessage(message);
		
		System.out.println("published the message");
		

	}

}
