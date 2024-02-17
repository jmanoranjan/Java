package com.masai;

import java.util.List;
import java.util.function.Consumer;


import java.util.ArrayList;
public class Problem1 {

	
	
	public static void main(String[] args) {
		
		
		List<String> list = new ArrayList<>();
		list.add("Bangalore");
		list.add("Berhamput");
		list.add("kuladea");
		list.add("Rambha");
		list.add("Bhanjanagar");
		
		Consumer<String> st = s -> System.out.println(s);
		
		
		
		PrintList pr = li -> {
			
			li.forEach(st);
		};
		
		pr.display(list);
		
		
		
		
	}
}


interface PrintList {
	void display(List<String> city);
}