package com.masai;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.Scanner;


public class problem_3 {
	
	static List<Country> filterCountry(List<Country> list, Predicate<Country> filterByArea){
		List<Country> filteredCountries = new ArrayList<>();
		for(Country country : list) {
			if(filterByArea.test(country)) {
				filteredCountries.add(country);
			}
		}
		
		
		
		return filteredCountries;
		
		
	}

	static void displayCountryList(List<Country> list) {
		
		Consumer<Country> consumer = c -> System.out.println(c.getCountryName()+"\t"+c.getContinentName()+"\t"+c.getArea());
		list.forEach(consumer);
		
	}
	
	public static void main(String[] args) {
		List<Country> countryList = new ArrayList<>();
		//Add countries from Asia
		countryList.add(new Country("China", "Asia", 9596961));
		countryList.add(new Country("Japan", "Asia", 377975));
		countryList.add(new Country("India", "Asia", 3287263));
		countryList.add(new Country("Russia", "Asia", 17098246));
		
		//Add countries from Europe
		countryList.add(new Country("Belgium", "Europe", 30528));
		countryList.add(new Country("Denmark", "Europe", 43094));
		countryList.add(new Country("Germany", "Europe", 357168));
		countryList.add(new Country("Norway", "Europe", 385203));
		
		//Add countries from Africa
		countryList.add(new Country("Egypt", "Africa", 1010408));
		countryList.add(new Country("Morocco", "Africa", 446300));
		countryList.add(new Country("South Africa", "Africa", 1221037));
		countryList.add(new Country("Kenya", "Africa", 580367));

		List<Country> filteredList = null;
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		do {
			System.out.println("1. By Area Range");
			System.out.println("2. By content in country name");
			System.out.println("3. By continent name");
			System.out.println("4. Clear Filter ");	
			System.out.println("5. Print Country List");
			System.out.println("0. Exit");
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					System.out.print("Enter minimum area ");
					double minArea = sc.nextDouble();
					System.out.print("Enter maximum area ");
					double maxArea = sc.nextDouble();
					Predicate<Country> filterByArea = c -> (c.getArea() >= minArea && c.getArea() <= maxArea);
					filteredList = filterCountry(filteredList == null?countryList: filteredList, filterByArea);
					break;
				case 2:
					System.out.print("Enter any character/string that country name has ");
					String countrySequence = sc.next();
					Predicate<Country> filterByName = c -> (c.getCountryName().contains(countrySequence));
					filteredList = filterCountry(filteredList == null?countryList: filteredList, filterByName);
					break;
				case 3:
					System.out.println("Enter continent name ");
					String continentName = sc.next();
					Predicate<Country> filterByContinentName = c -> (c.getContinentName().equals(continentName));
					filteredList = filterCountry(filteredList == null?countryList: filteredList, filterByContinentName);
					break;
				case 4:
					filteredList = null;
					System.out.println("Filter cleared! you can add filter from start");
					break;
				case 5:
					displayCountryList(countryList);
					break;
				case 0:
					System.out.println("Thanks for using our services");
					break;
				default:
					System.out.println("Invalid Selection, enter Again");
			}
		}while(choice != 0);
		sc.close();
		
	}
	
	
	
}


class Country{
	
	
	private String countryName;
	private String continentName;
	private double area;
	
	
	public Country(String countryName,String continentName,double area) {
		this.countryName = continentName;
		this.continentName = continentName;
		this.area = area;
		
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	public String getContinentName() {
		return continentName;
	}


	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}


	public double getArea() {
		return area;
	}


	public void setArea(double area) {
		this.area = area;
	}
	
	
}