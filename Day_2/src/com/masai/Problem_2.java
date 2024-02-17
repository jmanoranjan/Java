package com.masai;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Function;


import com.masai1.*;
public class Problem_2 {

	public static void main(String[] args) {
		
		System.out.println("hello world ");
		int count = 7;
		List<Student> students = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		do {
			
			String name;
			int roll;
			int marks;
			
			
			System.out.println( "enter the Student's name");
			name = sc.nextLine();
			   
			System.out.println("Enter the students roll number");
			roll = sc.nextInt();
			System.out.println("Enter student marks");
			marks = sc.nextInt();
			sc.nextLine();
			count++;
			students.add(new Student(roll, marks, name));
			
			
		}while(count < 10);
		sc.close();
		
		Function<List<Student>, Map<String , List<Student>>> fun = st -> {
			Map<String ,List<Student>> map = new HashMap<>();
			for(Student std : st) {
			int marks =  std.getMarks();
			String key;
			 if(marks < 165) {
				 key = "Fail";
			 }else if(marks < 400) {
				 key = "Pass";
			 }else {
				 key = "Topper";
			 }
			 
			 map.computeIfPresent(key, (k,value)-> {
				 value.add(std);
				 return value;
			 });
			 
			 
			 map.computeIfAbsent(key, value -> new ArrayList<>() ).add(std);
			
			}
			
			
			
			return map;
		};
		
		
		

		Map<String,List<Student>> retMap = fun.apply(students);
		BiConsumer<String , List<Student>> bc = (str,stList)->{
			
			System.out.println(str+" : categor :"+ stList);
		};
		
		retMap.forEach(bc);
		
		
		
	}
}


































class Student{
	
	private int roll;
	private int marks;
	private String name;
	
	public Student(int roll, int marks,String name) {
		this.roll = roll;
		this.marks = marks;
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





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	@Override
	public String toString() {
		return "Student [roll=" + roll + ", marks=" + marks + ", name=" + name + "]";
	}
	
	
}
