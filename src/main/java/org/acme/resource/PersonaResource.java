/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.acme.resource;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.panache.common.Sort;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.acme.entity.Person;
import org.acme.service.PersonaService;
import org.acme.model.PersonModel;
/**
 *
 * @author Cristian Leones
 */
@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonaResource {
    
	@Inject
	PersonaService personaService;

	@GET
	public List<PersonModel> get(){
		return personaService.get();
	}
	
	@POST
	public void create(PersonModel person){
		personaService.create(person);
	}
	
	@PUT
	public void update(PersonModel person){
		personaService.update(person);
	}
	
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Long id){
		personaService.delete(id);
	}
}
