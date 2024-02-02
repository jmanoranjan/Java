package com.masai1;
import java.util.Comparator;
import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		
		Comparator compsort = new Comparator() {
			@Override
			public int compare(Object a,Object b) {
				Product aProduct = (Product)a;
				Product bProduct = (Product)b;
				
				if(aProduct.getPrice() > bProduct.getPrice()) {
					return -1;
				}else if(aProduct.getPrice() < bProduct.getPrice()) {
					return 1;
					
				}else {
					if(aProduct.getQuantity() > bProduct.getQuantity()) {
						return -1;
					}else if(aProduct.getQuantity() < bProduct.getQuantity()) {
						return 1;
					}else {
						int ans = aProduct.getProductName().compareTo(bProduct.getProductName());
					if(ans > 0) {
						return -1;
					}else if(ans < 0) {
						return 1;
					}else {
						if(aProduct.getProductId() > bProduct.getProductId()) {
							return -1;
						}else {
							return 1;
						}
					}
					}
					
					
					
					
					
					
					
					
				}
				
			}
			
		};
		
		List<Product> list = new ArrayList<>();
		
		list.add(new Product(123,"Rjk",2,2222));
		list.add(new Product(23,"Ganha",10,555));
		list.add(new Product(432,"sjha",20,200));
		list.add(new Product(783,"Manrega",2,900));
		list.add(new Product(549,"Mjkah",15,1991));
		
	
		Collections.sort(list,compsort);
		System.out.println(list);
		
	}
}

class Product{
	private  int productId;
	private String productName;
	private int quantity;
	private int price;
	
	
	Product(){}
	public Product(int id,String name,int quantity,int price) {
		this.productId = id;
		this.productName = name;
		this.quantity = quantity;
		this.price = price;
		
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
