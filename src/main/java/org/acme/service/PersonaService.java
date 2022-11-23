/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.acme.service;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.panache.common.Sort;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.acme.entity.Person;
/**
 *
 * @author Cristian Leones
 */
@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonaService {
    
     @GET
    public List<Person> getAll() throws Exception {
        System.out.println(Person.findAll(Sort.ascending("last_name")).list());
        return Person.findAll(Sort.ascending("last_name")).list();
    }

    @POST
    @Transactional
    public Response create(Person p) {
        if (p == null || p.id != null)
            throw new WebApplicationException("id != null");
        p.persist();
        return Response.ok(p).status(200).build();
    }
    
    @PUT
    @Transactional
    @Path("{id}")
    public Person update(@PathParam("id") final Long id, Person p) {
        Person entity = Person.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Person with id of " + id + " does not exist.", 404);
        }
        if(p.salutation != null ) entity.salutation = p.salutation;
        if(p.firstName != null )  entity.firstName = p.firstName;
        if(p.lastName != null)    entity.lastName = p.lastName;
        return entity;
    }
    
    
    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") final Long id) {
        Person entity = Person.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Person with id of " + id + " does not exist.", 404);
        }
        entity.delete();
        return Response.status(204).build();
    }
}
