package com.qa.app;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.transaction.Transactional;

@Alternative
@ApplicationScoped
public class PersonRepositoryNoServer implements InterPersonRepository {
	
	private Long counter;
	private Map<Long, Person> data;
	
	@Override
	public String toString() {
		return "PersonRepositoryNoServer [counter=" + counter + ", data=" + data + "]";
	}

	public PersonRepositoryNoServer() {
		counter = new Long(1);
		data = new HashMap<>();
	}

	public List<Person> findAllPeople() {
		return new ArrayList<Person>(data.values());
	}

	public Person findPerson(Long id) {
		return data.get(id);
	}

	@Transactional(REQUIRED)
	public String addPerson(Person person) {
		data.put(counter++, person);
		return "Done";
	}
	
	@Transactional(REQUIRED)
	public String deletePerson(Long id) {
		data.remove(id);
		return "Deleted";
	}

	@Transactional(REQUIRED)
	public String updatePerson(Long id, String name) {
		data.get(id).setName(name);
		return "Updated";
	}
}
