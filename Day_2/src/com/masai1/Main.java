package com.masai1;
import java.util.function.Consumer;



public class Main {
	
	
	static void show(Consumer<? super Address> con) {
		
		
		con.accept(new Address("Manoranjan", 21, 23232,"Delhi",570020));
		
	}

	public static void main(String[] args) {
		// coverience and contraverience
		
		Consumer< ? super Address> consumer = a -> System.out.println(a);
		show(consumer);
		
		
		
	}
}


class Student1{
	private String name;
	private int roll;
	private int marks;
	
	public Student1(String name,int roll,int marks) {
		this.name = name;
		this.roll = roll;
		this.marks = marks;
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
}


class Address extends Student1{
	
	String city;
	int pincode;
	
	public Address(String name,int roll,int marks,String city,int pincode) {
		super(name, roll, marks);
		this.city = city;
		this.pincode = pincode;
		
		
	}
	
	
}


