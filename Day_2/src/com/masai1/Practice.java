package com.masai1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Practice {
	
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		
		students.add(new Student(11, 234, "gopikisan"));
		students.add(new Student(34, 500, "giri"));
		students.add(new Student(55, 360, "Manoranjan"));
		students.add(new Student(49, 490, "chitta"));
	
		
		
		
		Collections.sort(students,(Student a,Student b)-> (a.roll > b.roll)? 1:-1);
		
		Predicate<Student> p1 = st -> st.marks < 400;
		students.removeIf(s->s.marks < 400);
		
		
	}
	
}


class Student{
	
	int roll;
	int marks;
	String name;
	
	public Student(int roll, int marks,String name) {
		this.roll = roll;
		this.marks = marks;
		this.name = name;
		
	}
	
	

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", marks=" + marks + ", name=" + name + "]";
	}
	
	
}











