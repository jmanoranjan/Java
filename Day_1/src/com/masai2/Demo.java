package com.masai2;
import java.util.function.Predicate;

public class Demo {

	public static void main(String[] args) {
		
		Predicate<Integer> pr = p -> p > 0;
		
		
		Test<Student> st = new Test<Student>(new Student("Manoranjan"));
		 st.getDate().show();
		
		
	}
}


class Test<T extends Person>{
	
	T data;
	
	public Test(T value) {
		this.data = value;
	}
	
	public T getDate() {
		return this.data;
	}
}

interface Person{
	void show();
}

class Student implements Person {
	private String name;
	
	public Student(String name) {
		this.name = name;
	}
	@Override
	public void show() {
		System.out.println(this.name);
	}
}
