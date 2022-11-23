/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.acme.entity;
import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
/**
 *
 * @author Cristian Leones
 */
@Entity
public class Person extends PanacheEntity {
    

    @Column(name="first_name")
    public String firstName;

	@Column(name="last_name")
    public String lastName;

    public String salutation;
}
