package com.revature.micro.patient.tomcat.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String>{

	<S extends Patient> S save(S patient);
	List<Patient> findAll();
	
}
