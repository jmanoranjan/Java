package com.masai1;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerDemo {
	
	public static void main(String[] args) {
		Consumer<Integer> consumer = a -> System.out.println(a * a);
		consumer.accept(-10);
		consumer.accept(0);
		consumer.accept(5);
		
	   Map<String , Double> map = new HashMap<>();
	   map.put("India", 93845.0);
	   map.put("Nepal",692938.9);
	   map.put("SriLanka",38743.00);
	   map.put("miamar",387384.9);
	   
	   BiConsumer<String , Double> b2 = (name,area)->System.out.println("country name is :"+name+" area is : "+ area);
	   map.forEach(b2);
	}

}
