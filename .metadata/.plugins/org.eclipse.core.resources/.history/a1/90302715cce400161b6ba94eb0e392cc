package com.revature.micro.product.tomcat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Sends messages as JSON through Kafka queue
 * @author Patrick Walsh
 *
 */
@Component
public class CustomerMessageSender {

	/**
	 * Provides high-level interaction with Kafka queue.
	 * Abstracts the low-level messaging Kafka operations
	 */
	private KafkaTemplate<Integer, Customer> kafkaTemplate;

	@Autowired
	public void setKafkaTemplate(KafkaTemplate<Integer, Customer> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	/**
	 * Sends customer data to Kafka 
	 * @param customer
	 * @return
	 */
	public Customer saveCustomer(Customer customer){
		// broadcast asynchronous message to CREATE_CUSTOMER topic
		// any listener that subscribes to CREATE_CUSTOMER will be invoked
		ListenableFuture<SendResult<Integer, Customer>> future =
				kafkaTemplate.send("CREATE_CUSTOMER", customer);
		
		// register callback function to handle the success or failure of message
		future.addCallback(
				new ListenableFutureCallback<SendResult<Integer, Customer>>() {
					@Override
					public void onFailure(Throwable e) {
						System.out.println(e.getStackTrace());
					}
					@Override
					public void onSuccess(SendResult<Integer, Customer> result) {
						System.out.println("Success!");
					}
				});
		try{
			// await the completion of the message and extract the returned value
			return future.get().getProducerRecord().value();
		}catch(Exception e){
			return new Customer();
		}
		
	}
}
