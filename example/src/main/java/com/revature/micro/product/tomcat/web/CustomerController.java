/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.revature.micro.product.tomcat.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.micro.product.tomcat.service.Customer;
import com.revature.micro.product.tomcat.service.CustomerService;

/**
 * API Gateway example:
 * 	Exposes APIs to interact with MongoDB and customer microservice
 * @author Patrick Walsh
 *
 */
@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;

	@RequestMapping("/")
	public String helloWorld() {
		return "Customer Service: Spring Boot application connected to MongoDB. "
				+ "Listening for events on Apache Kafka";
	}
	
	/**
	 * Invokes a service that passes the customer to Kafka message queue
	 * @param customer
	 * @return
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Customer customer){
		service.save(customer);
	}
	
	///////////// Non-kafka convenience endpoints ////////////
	@RequestMapping(value="/find/name/first/{firstName}",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> findByFirstName(@PathVariable String firstName){
		return service.findByFirstName(firstName);
	}

	@RequestMapping(value="/find/name/last/{lastName}",
			method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> findByLastName(@PathVariable String lastName){
		return service.findByLastName(lastName);
	}
	
	@RequestMapping(value="/find/all",
			method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> findAll(){
		return service.findAll();
	}
}
