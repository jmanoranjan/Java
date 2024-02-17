package com.masai.practice;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StudentOperation {

	static Optional<List<Student>> findStudent(List<Student> studentList){
	List<Student> filterList = studentList.stream().filter(a->a.getGrade()>=55).collect(Collectors.toList());
	Optional<List<Student>> filterOpt = Optional.ofNullable(filterList);
	return filterOpt;
		
	}
	
	static int getOutstandingStudentCount(List<Student> studentList) throws NoStudentPassedException{
		
		Optional<List<Student>> optional = StudentOperation.findStudent(studentList);
		List<Student> passedStudents = optional.orElseThrow(()-> new NoStudentPassedException("No Student is passed "));
		return passedStudents.size();
		
		
	}
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student( "ABC",1, 85));
		studentList.add(new Student("BCD",2, 75));
		studentList.add(new Student("CDE",3, 65));
		studentList.add(new Student("DEF",4, 55));
		studentList.add(new Student("EFG",5, 45));
		
		try {
			System.out.println("Total passed students are " + StudentOperation.getOutstandingStudentCount(studentList));
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getLocalizedMessage());
		}
		
		
		
		
		
	}
}


class NoStudentPassedException extends Exception{
	public NoStudentPassedException() {}
	public NoStudentPassedException(String msg) {
		super(msg);
	}
}


