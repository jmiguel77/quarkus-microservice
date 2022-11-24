/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.acme.service;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import org.acme.entity.Person;
import org.acme.model.PersonModel;
/**
 *
 * @author Cristian Leones
 */

@ApplicationScoped
public class PersonaService {
    
    public List<PersonModel> get() {
		List<Person> listAll = Person.findAll().list();
		return listAll.stream().map(ie -> {
						return new PersonModel(ie.id, ie.firstName, ie.lastName, ie.salutation);
					}).collect(Collectors.toList());
	}
    
    @Transactional
	public void create(PersonModel personModel) {
		Person ie = new Person();
		ie.firstName = personModel.getFirstName();
		ie.lastName = personModel.getLastName();
		ie.salutation = personModel.getSalutation();
		ie.persist();
	}
	
	@Transactional
	public void update(PersonModel personModel) {
		Person entity = Person.findById(personModel.getId());
		entity.firstName = personModel.getFirstName();
		entity.lastName = personModel.getLastName();
		entity.salutation = personModel.getSalutation();
           
                
	}
	
	@Transactional
	public void delete(Long id) {
		Person.deleteById(id);
	}
}
