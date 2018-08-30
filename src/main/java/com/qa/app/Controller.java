package com.qa.app;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("person")
public class Controller {
	
	@Inject
	private Services service;
	
	@Path("all")
	@GET
	public String findAllPeople() {
		return util.toJson(service.findAllPeople());
	}
	
	@Path("one/{id}")
	@GET
	public String findPerson(@PathParam("id") Long id) {
		return util.toJson(service.findPerson(id));
	}
	
	@Path("add/{name}/{acc}")
	@PUT
	public String addPerson(@PathParam("name") String name, @PathParam("acc") String acc) {
		return service.addPerson(new Person(name, acc));
	}

	@Path("delete/{id}")
	@PUT
	public String deletePerson(@PathParam("id") Long id) {
		return service.deletePerson(id);
	}
	
	@Path("update/{id}/{name}")
	@PUT
	public String updatePerson(@PathParam("id") Long id, @PathParam("name") String name) {
		return service.updatePerson(id, name);
	}
}
