package com.crud.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Data
@Entity
public class Employee {
	@javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	String eid;
	String ename;
	String esal;
	
	

}
