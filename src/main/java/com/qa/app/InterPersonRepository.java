package com.qa.app;

import java.util.List;

public interface InterPersonRepository {
	public List<Person> findAllPeople();
	public Person findPerson(Long id);
	public String addPerson(Person person);
	public String deletePerson(Long id);
	public String updatePerson(Long id, String name);
}
