package com.masai2;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static void findStudentWithSameState(List<? super Student> sameState,List<? extends Student> schoolList,List<? extends Student> collegeList,String stateName){
		
		
		for(Student st: schoolList ) {
			if(st.getState().equalsIgnoreCase(stateName)) {
				sameState.add(st);
			}
		}
		
		
		for(Student st : collegeList) {
			if(st.getState().equalsIgnoreCase(stateName)) {
				sameState.add(st);
			}
		}
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		List<SchoolStudent> ssList = new ArrayList<>();
		ssList.add(new SchoolStudent(1, "ABC", "Bihar", "CBSE"));
		ssList.add(new SchoolStudent(2, "BCD", "Jharkhand", "CBSE"));
		ssList.add(new SchoolStudent(3, "CDE", "Bihar", "BBSE"));
		
		List<CollegeStudent> scList = new ArrayList<>();
		scList.add(new CollegeStudent(1, "VWX", "Jharkhand", "State University"));
		scList.add(new CollegeStudent(2, "WXY", "Bihar", "National University"));
		scList.add(new CollegeStudent(3, "XYZ", "Jharkhand", "State University"));
		
		List<Student> sameStateList = new ArrayList<Student>();
		findStudentWithSameState(sameStateList, ssList, scList, "Bihar");
		System.out.println(sameStateList);
		
	}
	
}




class SchoolStudent extends Student{
	
	
	private String boardName;
	
	public SchoolStudent(int rollNo,String name,String state,String boardName) {
		super(rollNo, boardName, state);
		this.boardName = boardName;
		
	}

	@Override 
	public String toString() {
		return super.toString() + " boardName : "+ this.boardName;
	}
	
	public String getBoardName() {
		return this.boardName;
	}
	
	
}


class CollegeStudent extends Student{
	
	private String universityName;
	
	public CollegeStudent(int rollNo,String name,String state,String universityName ) {
		super(rollNo, universityName, state);
		this.universityName = universityName;
		
	}
	
	
	@Override
	public String toString() {
		return super.toString() + " universityName : "+ this.universityName;
		
	}
	
	public String getUniversityName() {
		return this.universityName;
	}
}

abstract class Student{
	
	private int rollNo;
	private String name;
	private String state;
	
	public Student(int rollNo,String name,String state) {
		this.rollNo = rollNo;
		this.name = name;
		this.state = state;
		
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", state=" + state + "]";
	}
	
	public String getState() {
		return state;
	}
	
	
}











