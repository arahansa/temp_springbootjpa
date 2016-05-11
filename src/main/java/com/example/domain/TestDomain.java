package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class TestDomain {
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String address;
	private String desc;
	
	public TestDomain(){
		
	}
	
	public TestDomain(String name, String address, String desc){
		this.name = name;
		this.address = address;
		this.desc = desc;
	}

}
