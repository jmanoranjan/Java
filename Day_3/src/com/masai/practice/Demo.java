package com.masai.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Demo {

	public static void main(String[] args) {
		Customer customer = new Customer(88, "Giri",null , Arrays.asList("3435343443","3432343334"));
		
		Optional<Object> emptyOpt = Optional.empty();
		System.out.println("Empty Optional Object "+ emptyOpt);
		Optional<String> email = Optional.ofNullable(customer.getEmail());
	      if(emptyOpt.isPresent()) {
	    	  System.out.println(emptyOpt.get());
	      }else {
	    	  System.out.println("hello ji nothing is present inside the optional object ");
	      }
	}

	
	
}

class Customer{
	private int id;
	private String name;
	private String email;
	private List<String> phoneNumber;
	
	public Customer(int id,String name,String email,List<String> numbers) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = numbers;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
