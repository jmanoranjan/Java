package com.masai1;

import java.util.function.Supplier;

public class SupplierDemo {

	public static void main(String[] args) {
		Supplier<Integer> supplier = ()-> (int)(Math.random() * 10);
		System.out.println(supplier.get());
	}
}
