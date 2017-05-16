package com.rest.services;

import com.rest.model.Person;
import com.rest.model.Response;

public interface PersonService {

	public Response addPerson(Person p);
	public Response deletePerson(int id);
	public Person getPerson(int id);
	public Person[] getAllPerson();
}
