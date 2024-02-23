package com.masai;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;
public class Problem_2 {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,4,5,6,7,8,8,9);
	   IntStream list2 = list.stream().mapToInt(a->a);
	   System.out.println(list2.sum());
		List<Fruit> fruits = Arrays.asList(
				new Fruit("Orange", 10, 89),
				new Fruit("Papaya", 20, 90),
				new Fruit("Apple", 10, 45),
				new Fruit("Watermelon", 10, 56),
				new Fruit("Guava", 10, 40),
				new Fruit("Pomegranate", 10, 200)
			);
		
		Map<String, Double> map = fruits.stream().collect(Collectors.toMap(a->a.name,a->a.price*a.quantity));
		double total = fruits.stream().mapToDouble(f->f.price*f.quantity).sum();
		fruits.stream().filter(f->f.price  > 50).forEach(System.out::println);
		
		
	}
}

class Fruit{
	String name;
	int quantity;
	double price;
	public Fruit(String name,int quantity,double price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		
	}
	
	@Override
	public String toString() {
		return name+ "\t" +quantity+ "\t" +price;
	}
	
}
