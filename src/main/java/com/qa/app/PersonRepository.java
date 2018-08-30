package com.qa.app;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;

@Default
@Transactional(SUPPORTS)
public class PersonRepository implements InterPersonRepository {
	@PersistenceContext(name = "primary")
	private EntityManager manager;
	
	public List<Person> findAllPeople() {
		return manager.createQuery("select m from Person m", Person.class).getResultList();
	}
	
	public Person findPerson(Long id) {
		return manager.find(Person.class, id);
	}
	
	@Transactional(REQUIRED)
	public String addPerson(Person person) {
		manager.persist(person);
		return "done";
	}
	
	@Transactional(REQUIRED)
	public String deletePerson(Long id) {
		Person person = findPerson(id);
		if (person != null) manager.remove(person);
		return "Deleted";
	}
	
	@Transactional(REQUIRED)
	public String updatePerson(Long id, String name) {
		Person person = findPerson(id);
		Person updatePerson = new Person(name, person.getAccountNumber());
		updatePerson.setId(id);
		if(person != null) 	manager.merge(updatePerson);
		return "Updaterood";
	}

}
