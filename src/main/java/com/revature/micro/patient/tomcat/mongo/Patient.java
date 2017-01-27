package com.revature.micro.patient.tomcat.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="patients")
public class Patient {

	@Id
	private int patientId;
	private String firstName;
	private String lastName;
	
	public Patient() {
		super();
	}

	public Patient(int patientId, String firstName, String lastName) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
