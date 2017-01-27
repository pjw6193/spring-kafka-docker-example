package com.revature.micro.product.tomcat.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	public List<Customer> findByFirstName(String firstName);

	public List<Customer> findByLastName(String lastName);
	
	@Override
	public <S extends Customer> S save(S customer);
	
	@Override
	public List<Customer> findAll();

}