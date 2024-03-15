package com.jspiders.carDekho.dao;

import java.util.Scanner;

public class CarMenu {
	
	private static Scanner scanner = new Scanner(System.in);
	private static boolean loop=true;
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
		
		while (loop) {
			mainMenu();
		}
	}

	private static void mainMenu() {
		System.out.println("*****Menu*****");
		System.out.print("1.View All Cars\n" + "2.Search Cars\n" + "3.Add Car\n" + "4.Remove Car\n" + "5.Edit Car\n"
				+ "6.Exit\n");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			viewCars();
			break;
		case 2:
			searchCar();
			break;
		case 3:
			addCar();
			break;
		case 4:
			removeCar();
			break;
		case 5:
			editCar();
			break;
		case 6:
			System.out.println("Thank you!");
			loop = false;
			break;
		default:
			System.out.println("Invalid input..!!");
			break;
		}
	}
	
	private static void viewCars() {

	}

	private static void searchCar() {

	}

	private static void addCar() {

	}

	private static void removeCar() {

	}

	private static void editCar() {

	}
}
