package com.qa.app;

import java.util.List;

import javax.inject.Inject;

public class Services {
	
	@Inject
	private InterPersonRepository rep;
	
	public List<Person> findAllPeople() {
		return rep.findAllPeople();
	}
	public Person findPerson(Long id) {
		return rep.findPerson(id);
	}
	public String addPerson(Person person) {
		if(person.getAccountNumber().equals("9999")) return "{“message”: “This account is blocked”}";
		return rep.addPerson(person);
	}
	public String deletePerson(Long id) {
		return rep.deletePerson(id);
	}
	public String updatePerson(Long id, String name) {
		return rep.updatePerson(id, name);
	}
}
