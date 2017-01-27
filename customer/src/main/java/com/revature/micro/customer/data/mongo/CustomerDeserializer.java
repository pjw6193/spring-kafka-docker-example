package com.revature.micro.customer.data.mongo;

import org.springframework.kafka.support.serializer.JsonDeserializer;

/**
 * JsonDeserializer is required to convert Json message in Kafka into Java object.
 * JsonDeserializer constructor is protected and ObjectMapper inside it is typed <T>.
 * 
 * If you do not have a deserializer like this, Apache Kafka Utils cannot access 
 * JsonDeserializer constructor.
 * 
 * @author Patrick Walsh
 *
 */
public class CustomerDeserializer extends JsonDeserializer<Customer>{

	public CustomerDeserializer() {
	
	}
	
}
