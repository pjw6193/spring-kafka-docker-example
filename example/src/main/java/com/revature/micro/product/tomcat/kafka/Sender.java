package com.revature.micro.product.tomcat.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.revature.micro.product.tomcat.service.Customer;

@Component
public class Sender {

	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

	@Autowired
	private KafkaTemplate<Integer, Customer> kafkaTemplate;

	public void sendMessage(String topic, final Customer message) {
		System.out.println("Sending Message through Kafka");
		// the KafkaTemplate provides asynchronous send methods returning a
		// Future
		ListenableFuture<SendResult<Integer, Customer>> future = kafkaTemplate.send(topic, message);

		// you can register a callback with the listener to receive the result
		// of the send asynchronously
		future.addCallback(new ListenableFutureCallback<SendResult<Integer, Customer>>() {

			@Override
			public void onSuccess(SendResult<Integer, Customer> result) {
				LOGGER.info("sent message='{}' with offset={}", message, result.getRecordMetadata().offset());
			}

			@Override
			public void onFailure(Throwable ex) {
				LOGGER.error("unable to send message='{}'", message, ex);
			}
		});

		// alternatively, to block the sending thread, to await the result,
		// invoke the future’s get() method
	}
}
