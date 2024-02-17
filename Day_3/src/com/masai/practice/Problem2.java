package com.masai.practice;
import java.util.ArrayList;
import java.awt.print.Printable;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Problem2 {
	
	

	public static void  printStudents(List<Student> studentList,Predicate<Student> ageFilter,Predicate<Student> gradeFilter,Consumer<Student> stPrint) {
		
		
		
		studentList.stream().filter(ageFilter).filter(gradeFilter).forEach(stPrint);
		
		
		
	}
	
	public static void main(String[] args) {
		
		Predicate<Student> af = Student::ageFilt;
		Predicate<Student> gf = Student::gradeFilt;
		Consumer<Student> print = System.out::println;
	
		 List<Student> students = new ArrayList<>();
	        students.add(new Student("John", 18, 85.5));
	        students.add(new Student("Emma", 21, 76.0));
	        students.add(new Student("Michael", 19, 92.3));
	        
	        printStudents(students, af, gf, print);
    
	}
}






class Student{
	private String name;
	private int age;
	private double grade;
	
	public boolean ageFilt() {
		return age<20;
	}
	
	public boolean gradeFilt() {
		return grade >= 80;
	}
	
	
	public Student(String name,int age,double grade) {
		this.name = name;
		this.age = age;
		this.grade = grade;
		
	}

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

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "Name\t"+name+" age\t"+age + " Grade\t"+grade;
		
	}
}