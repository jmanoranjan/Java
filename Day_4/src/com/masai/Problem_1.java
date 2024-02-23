package com.masai;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;

public class Problem_1 {

	public static void main(String[] args) {
	
   ObjectCreate obc = Product::new;
   List<Product> products = new ArrayList<>();
   //add 5 product into the product arrayList;
   
   products.add(obc.getObject("Mango","m1",50, 10));
   products.add(obc.getObject("Apple","a1",110, 20));
   products.add(obc.getObject("Orange","o1",130, 15));
   products.add(obc.getObject("Lichi","l1",80, 18));
   products.add(obc.getObject("Grapes","g1",90, 30));
   //filter whose quantity is more then 10
 
   List<Product> mtp = products.stream().filter(p-> p.getQuantity() >= 10).sorted((a,b)->Double.compare(a.getPrice(), b.getPrice())).collect(Collectors.toList());
   mtp.forEach(System.out::println);
   
   List<Customer> customers = new ArrayList<>();
   customers.add(new Customer("Alice", 25, "Female", "New York"));
   customers.add(new Customer("Bob", 35, "Male", "Los Angeles"));
   customers.add(new Customer("Charlie", 45, "Male", "Chicago"));
   customers.add(new Customer("Diana", 30, "Female", "Houston"));
   customers.add(new Customer("Eve", 40, "Female", "San Francisco"));
   customers.add(new Customer("Frank", 20, "Male", "Boston"));
   customers.add(new Customer("Grace", 50, "Female", "Seattle"));
   customers.add(new Customer("Harry", 55, "Male", "Miami"));
   customers.add(new Customer("Ivy", 28, "Female", "Dallas"));
   customers.add(new Customer("Jack", 33, "Male", "Phoenix"));   
	List<String> customersName = customers.stream().map(n->n.getName()).collect(Collectors.toList());
	customers.stream().sorted((a,b)->Integer.compare(a.getAge(), b.getAge())).forEach(System.out::println);
	
		
	}
}

@FunctionalInterface
interface ObjectCreate{
	Product getObject(String name,String productId,double price,int quantity);
}

class Product{
	
	private String productName;
	private String productId;
	private double price;
	private int quantity;
	
	public Product(String name,String id,double price,int quantity) {
		this.productName = name;
		this.productId = id;
		this.price = price;
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return productName+"\t"+productId+"\t"+price+"\t"+quantity;
	}
}

 class Customer {
    private String name;
    private int age;
    private String gender;
    private String city;
    // Constructor, getters and setters
    
    public Customer(String name,int age, String gender,String city) {
    	this.name = name;
    	this.age = age;
    	this.gender = gender;
    	this.city = city;
    	
    	
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
    
	@Override
	public String toString() {
		return name+"\t"+age+"\t"+ gender +"\t"+city;
	}
    
}
 
 
 
 
 