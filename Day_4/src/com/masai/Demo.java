package com.masai;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.ArrayList;

import java.util.Map.Entry;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(2,3,4,5,6);
		List<Double> doubleList = Arrays.asList(2.5,1.5,3.5,4.5);
		  double ans = intList.stream().collect(Collectors.averagingInt(i-> i));
	  ToDoubleFunction<Double> dub = i-> i*1.0;
	  double doubleAns = doubleList.stream().collect(Collectors.averagingDouble(dub));
	  
	  System.out.println(ans);
	  System.out.println(doubleAns);
	  System.out.println("-------------------");
	  
	  ToDoubleFunction<Integer> tdf2 = a -> a;
	  double sum = intList.stream().collect(Collectors.summingDouble(tdf2));
	  System.out.println("The double sum is "+ sum);
	  int sum2 = intList.stream().collect(Collectors.summingInt(a->a));
	  System.out.println("This the summingInt function "+sum2);
	  int  sum3 = doubleList.stream().collect(Collectors.summingInt(a->a.intValue()));
	  System.out.println("the change sum ans is the "+ sum2);
	  ToIntFunction<Integer> dd3 = a-> a;
	  ToDoubleFunction<Integer> dd5 = a-> a*1.0;
	  List<Integer> list = Arrays.asList(1,1,2,2,3,4,5,6,7,8,8,9);
	  list.stream().distinct().collect(Collectors.toList()).forEach(a-> System.out.print(a+" "));
	  Optional<Integer> retvalue = list.stream().findAny();
	  System.out.println(retvalue.get()+"This is the retvalue in the optional class and if the optinal is emepty then it return a empty optional class and if the there are some valut then it return a that value is contains the in the optional class ");
	  Optional<Integer> intFirst = list.stream().findFirst();
	  if(intFirst.isPresent()) {
		  System.out.println(intFirst.get());
	  }
	  
	  
	 List<Student> students = new ArrayList<>();
	 students.add(new Student("Pintu bhai",2, 454));
	 students.add(new Student("Mantu", 21,454));
	 students.add(new Student("pinku",32, 100));
	 students.add(new Student("Manor",29,469));
	 students.add(new Student("Giri", 69,500));
	 
	Function<Student,String> nameFun = Student::getName;
	Function<Student, Integer> marksFun = Student::getMarks;
	Map<String,Integer> map = students.stream().collect(Collectors.toMap(Student::getName,Student::getMarks));
	BiConsumer<String,Integer> bc = (a,b)-> System.out.println("Student name is "+a+"\tStudent makrs is "+b);
	map.forEach(bc);
   Iterator<Map.Entry<String, Integer>> itr = map.entrySet().iterator();
    List<Integer> list2 = Arrays.asList(1,2,3,4,5,6,6,6,7,8,9);
    System.out.println(list2.stream().distinct().collect(Collectors.toList()));
    list2.stream().skip(1).limit(3).forEach(i->System.out.print(i));
    
    
   
	
	
	 
		
	}
			
	
}



class Student{
	String name;
	int roll;
	int marks;
	
	public Student(String name,int roll,int marks) {
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