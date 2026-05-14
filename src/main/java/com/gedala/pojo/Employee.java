package com.gedala.pojo;

import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "set")
@Getter // IMP for serialization
public class Employee {

	private int id;
	private String firstname;
	private String lastname;
	private String email;

}
