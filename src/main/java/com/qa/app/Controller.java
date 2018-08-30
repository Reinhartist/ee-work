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
import javax.ws.rs.QueryParam;
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
	
	@Path("one")
	@GET
	public String findPerson(@QueryParam("id") Long id) {
		return util.toJson(service.findPerson(id));
	}
	
	@Path("add")
	@POST
	public String addPerson(String body) {
		return service.addPerson(util.fromJson(body, Person.class));
	}

	@Path("delete")
	@PUT
	public String deletePerson(@QueryParam("id") Long id) {
		return service.deletePerson(id);
	}
	
	@Path("update")
	@PUT
	public String updatePerson(@QueryParam("id") Long id, @QueryParam("name") String name) {
		return service.updatePerson(id, name);
	}
}
