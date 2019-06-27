package com.esfirst.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="company",type="staff" , shards=1)
public class Staff {
//  @Id
//  public ObjectId _id;
  @NotNull(message="id cannot be null")
  //@Size(min=1,max=500,message="id must be greater than 1 and less than 500")
  @Id
  private Integer id;
  @NotNull(message="name cannot be null")
  private String name;
  @NotNull(message="age cannot be null")
  private int age;
  @NotNull(message="email cannot be null")
  @Email
  private String email;
  @NotNull(message="department cannot be null")
  private String department;
  public Staff() {}
  
  public Staff(Integer id ,String name,int age,String email,String department)
  {
    this.id = id;
    this.name = name;
    this.age=age;
    this.email=email;
    this.department=department;
    
  }
  public Integer getId() { return id; }
  public void setId(Integer id) { this.id = id; }


public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}   
}
