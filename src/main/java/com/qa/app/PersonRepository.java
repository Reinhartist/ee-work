package com.qa.app;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;

@Transactional(SUPPORTS)
public class PersonRepository {
	@PersistenceContext(name = "primary")
	private EntityManager manager;
	
	public List<Person> findAllPeople() {
		TypedQuery<Person> query = manager.createQuery("select m from person", Person.class);
		return query.getResultList();
	}
	
	public Person findPerson(Long id) {
		return manager.find(Person.class, id);
	}
	
	@Transactional(REQUIRED)
	public Person addPerson(Person person) {
		manager.persist(person);
		return person;
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
		if(person != null) {
			manager.merge(new Person(name, person.getAccountNumber()));
		}
		return "Updaterood";
	}

}
