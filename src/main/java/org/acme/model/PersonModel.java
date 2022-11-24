/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.acme.model;

/**
 *
 * @author Cristian Leones
 */
public class PersonModel {
    
    public Long id;
    public String firstName;
    public String lastName;
    public String salutation;

    public PersonModel(Long id, String firstName, String lastName, String salutation) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salutation = salutation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }
   
    
    
}
