package com.masai.practice;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		
		CreateEmployeeObject co = Employee::new;
		Employee emp = co.getObject(1,"ABC", 45000);
		ShowDetails sd = emp::toString;
		System.out.println(sd.getEmployeeDetailsInString());
		System.out.println("------------");
		List<Employee> employeeList = new ArrayList<>();
		Employee empOne = co.getObject(2, "BCD", 45800);
		Employee empTwo = co.getObject(3, "CDE", 46800);
		Employee empThree = co.getObject(4, "DEF", 49700);
		Collections.addAll(employeeList, emp, empOne, empTwo, empThree);
		
		
		
		Collections.sort(employeeList,Employee::compareTo);
		for(Employee employee: employeeList) {
			System.out.println(employee);
		}
		
		FindMin min = EmployeeOperations::getEmployeeWithMinimumSalary;
		System.out.println("The employee with minimum salary is " + min.getMinSalariedEmployee(employeeList));
		
           
	}
}


class EmployeeOperations{
	static String getEmployeeWithMinimumSalary(List<Employee> employeeList) {
		Optional<Employee> name = employeeList.stream().min(Comparator.comparingDouble(Employee::getSalary));
		String minName = name.map(Employee::getName).orElse("");
		return minName;
		
		
	}
}

@FunctionalInterface
interface CreateEmployeeObject{
	Employee getObject(int employeeId, String name, double salary);
}

@FunctionalInterface
interface ShowDetails {
	String getEmployeeDetailsInString();
}

@FunctionalInterface
interface FindMin{
	String getMinSalariedEmployee(List<Employee> employeeList);
}






class Employee implements Comparable<Employee>{
	private String name;
	private int employeeId;
	private double salary;
	
	public Employee(int employeeId,String name,double salary) {
		this.name = name;
		this.employeeId = employeeId;
		this.salary = salary;		
		
	}

	@Override
	public String toString() {
		return "employeeId = " + employeeId + ", name= " + name + ", salary= " + salary ;
	}
	
	@Override
	public int compareTo(Employee o) {
		//sort in ascending order of salary
		if(salary > o.salary)
			return 1;
		else if(salary < o.salary)
			return -1;
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
