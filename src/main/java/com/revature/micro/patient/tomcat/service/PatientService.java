package com.revature.micro.patient.tomcat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.micro.patient.tomcat.mongo.Patient;
import com.revature.micro.patient.tomcat.mongo.PatientRepository;

@Service
public class PatientService {

	private PatientRepository repository;
	
	@Autowired
	public void setRepository(PatientRepository repository) {
		this.repository = repository;
	}
	
	public void save(Patient patient){
		repository.save(patient);
	}
	
	public List<Patient> findAll(){
		return repository.findAll();
	}
	
}
