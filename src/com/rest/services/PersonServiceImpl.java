package com.rest.services;

import java.util.HashMap;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.model.Person;
import com.rest.model.Response;
@Path("/person")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class PersonServiceImpl implements PersonService{

	private static HashMap<Integer,Person> Persons= new HashMap<>();
	@Override
	@POST
	@Path("/add")
	public Response addPerson(Person p) {
		Response response = new Response();
		if(Persons.get(p.getId())!=null){
			response.setStatus(false);
			response.setMessage("Person already exists");
		}
		else {
			Persons.put(p.getId(), p);
			response.setStatus(true);
			response.setMessage("person added");
		}
		return response;
	}

	@Override
	@GET
	@Path("/{id}/delete")
	public Response deletePerson(@PathParam("id") int id) {
	Response response = new Response();
	if(Persons.get(id)==null){
		response.setStatus(false);
		response.setMessage("person does not exists");
	}
	Persons.remove(id);
	response.setStatus(true);
	response.setMessage("removed");
		return response;
	}

	@Override
	@GET
	@Path("{id}/get")
	public Person getPerson(@PathParam("id") int id) {
		
		return Persons.get(id);
	}

	@Override
	@GET
	@Path("/getAll")
	public Person[] getAllPerson() {
		Set<Integer> keys = Persons.keySet();
		int i=0;
		Person[] p = new Person[keys.size()];
		for(int f:keys){
			p[i]=Persons.get(f);
			i++;
		}
		return p;
	}

}
