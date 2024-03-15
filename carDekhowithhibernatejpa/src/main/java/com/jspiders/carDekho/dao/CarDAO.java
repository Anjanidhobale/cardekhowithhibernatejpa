package com.jspiders.carDekho.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.carDekho.dto.CarDTO;

public class CarDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static Scanner scanner = new Scanner(System.in);
	private static boolean loop = true;
//	private static CarDTO car;

	public static void main(String[] args) {

		openConnection();
		while (loop) {
			mainMenu();
		}
		closeConnection();
	}

	private static void mainMenu() {
		System.out.println("*****Menu*****");
		System.out.print("1.View All Cars\n" + "2.Search Cars\n" + "3.Add Car\n" + "4.Remove Car\n" + "5.Edit Car\n"
				+ "6.Exit\n");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			openConnection();
			entityTransaction.begin();
			List<CarDTO> cars = viewCars();
			for (CarDTO car : cars) {
				System.out.println(car);
			}
			entityTransaction.commit();
			closeConnection();
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

	@SuppressWarnings("unchecked")
	private static List<CarDTO> viewCars() {
			Query query = entityManager.createQuery("SELECT car from CarDTO car");
			List<CarDTO> cars = query.getResultList();
			return cars;
	}

	private static void searchCar() {
		System.out.println("*****Search Car*****\n" + "1. Search by Id\n" + "2. Search by Name\n"
				+ "3. Search by Brand\n" + "4. Search by Fuel Type\n" + "5. Search by Color\n" + "6. Search by Price\n"
						+ "7. Go Back\n");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();
		
		switch (choice) {
		case 1:
			searchById();
			break;
		case 2:
			searchByName();
			break;
		case 3:
			searchByBrand();
			break;
		case 4:
			searchByFuelType();
			break;
		case 5:
			searchByColor();
			break;
		case 6:
			searchByPrice();
			break;
		case 7:
			System.out.println("Go back to main menu..");
			mainMenu();
			break;
		default:
			System.out.println("Invalid input..Please try again..!");
			break;
		}	
			
		}

	private static void searchById() {
		while (true) {
			try {
				openConnection();
				System.out.print("Enter the car id: ");
				int id = scanner.nextInt();
				CarDTO car = entityManager.find(CarDTO.class, id);
				if (car != null) {
					System.out.println(car);
				} else {
					System.out.println("Car with id-"+id+" does not exist!");
				}
				closeConnection();
			}catch (NullPointerException e) {
				System.out.println("Car does not exist!");
				System.out.println("Please enter a valid id!");
				scanner.nextLine();
				continue;
			}
			break;
		}
	}

	@SuppressWarnings("unchecked")
	private static void searchByName() {
		while (true) {
			try {
				openConnection();
				entityTransaction.begin();
				System.out.print("Enter the car name: ");
				String name = scanner.next();
				Query query = entityManager.createQuery("SELECT car from CarDTO car WHERE name = ?6");
				query.setParameter(6, name);
				List<CarDTO> cars= query.getResultList();
				if (cars.isEmpty()) {
					System.out.println("No cars found in the specified name.");
				} else {
					for (CarDTO car : cars) {
						System.out.println(car);
					}
				}
				entityTransaction.commit();
				closeConnection();
			}catch (NullPointerException e) {
				System.out.println("Car does not exist!");
				System.out.println("Please enter a valid id!");
				scanner.nextLine();
				continue;
			}
			break;
		}
	}
	
	@SuppressWarnings("unchecked")
	private static void searchByBrand() {
		while (true) {
			try {
				openConnection();
				entityTransaction.begin();
				System.out.print("Enter the brand name: ");
				String brand = scanner.next();
				Query query = entityManager.createQuery("SELECT car from CarDTO car WHERE brand = ?2");
				query.setParameter(2, brand);
				List<CarDTO> cars= query.getResultList();
				if (cars.isEmpty()) {
					System.out.println("No cars found with specified brand name.");
				} else {
					for (CarDTO car : cars) {
						System.out.println(car);
					}
				}
				entityTransaction.commit();
				closeConnection();
			}catch (NullPointerException e) {
				System.out.println("Car does not exist!");
				System.out.println("Please enter a valid id!");
				scanner.nextLine();
				continue;
			}
			break;
		}
	}

	@SuppressWarnings("unchecked")
	private static void searchByFuelType() {
		while (true) {
			try {
				openConnection();
				entityTransaction.begin();
				System.out.print("Enter the fuelType: ");
				String fuelType = scanner.next();
				Query query = entityManager.createQuery("SELECT car from CarDTO car WHERE fuelType = ?4");
				query.setParameter(4, fuelType);
				List<CarDTO> cars= query.getResultList();
				if (cars.isEmpty()) {
					System.out.println("No cars found in the specified fuel type.");
				} else {
					for (CarDTO car : cars) {
						System.out.println(car);
					}
				}
				entityTransaction.commit();
				closeConnection();
			}catch (NullPointerException e) {
				System.out.println("Car does not exist!");
				System.out.println("Please enter a valid id!");
				scanner.nextLine();
				continue;
			}
			break;
		}
	}
	
	@SuppressWarnings("unchecked")
	private static void searchByColor() {
		while (true) {
			try {
				openConnection();
				entityTransaction.begin();
				System.out.print("Enter the color: ");
				String color = scanner.next();
				Query query = entityManager.createQuery("SELECT car from CarDTO car WHERE color = ?3");
				query.setParameter(3, color);
				List<CarDTO> cars= query.getResultList();
				if (cars.isEmpty()) {
					System.out.println("No cars found with "+color+" color");
				} else {
					for (CarDTO car : cars) {
						System.out.println(car);
					}
				}
				entityTransaction.commit();
				closeConnection();
			}catch (NullPointerException e) {
				System.out.println("Car does not exist!");
				System.out.println("Please enter a valid id!");
				scanner.nextLine();
				continue;
			}
			break;
		}
	}
	
	@SuppressWarnings("unchecked")
	private static void searchByPrice() {
		while (true) {
			try {
				openConnection();
				entityTransaction.begin();
				System.out.print("Enter the min range: ");
				double min = scanner.nextDouble();
				System.out.print("Enter the max range: ");
				double max = scanner.nextDouble();
				Query query = entityManager.createQuery("SELECT car from CarDTO car WHERE price>=?1 AND price<=?2");
				query.setParameter(1, min);
				query.setParameter(2, max);
//				query.setParameter(6, name);
				List<CarDTO> cars= query.getResultList();
				if (cars.isEmpty()) {
					System.out.println("No cars found in the specified price range.");
				} else {
					for (CarDTO car : cars) {
						System.out.println(car);
					}
				}
				entityTransaction.commit();
				closeConnection();
			}catch (NullPointerException e) {
				System.out.println("Car does not exist!");
				System.out.println("Please enter a valid id!");
				scanner.nextLine();
				continue;
			}
			break;
		}
	}

	private static void addCar() {
		System.out.print("Enter car id: ");
		int id = scanner.nextInt();
		System.out.print("Enter car name: ");
		String name = scanner.next();
		System.out.print("Enter car model: ");
		String model = scanner.next();
		System.out.print("Enter car brand: ");
		String brand = scanner.next();
		System.out.print("Enter car fuel type: ");
		String fuelType = scanner.next();
		System.out.print("Enter car color: ");
		String color = scanner.next();
		System.out.print("Enter car price: ");
		double price = scanner.nextDouble();

		CarDTO car = new CarDTO();
		car.setId(id);
		car.setName(name);
		car.setModel(model);
		car.setBrand(brand);
		car.setFuelType(fuelType);
		car.setColor(color);
		car.setPrice(price);

		openConnection();
		entityTransaction.begin();

		entityManager.persist(car);
		System.out.println("Car added successfully");

		entityTransaction.commit();
		closeConnection();
	}

	private static void removeCar() {
		while (true) {
			try {
				openConnection();
				entityTransaction.begin();
				System.out.print("Enter the car id you want delete: ");
				int id = scanner.nextInt();
				CarDTO car = entityManager.find(CarDTO.class, id);
				if (car != null) {
					entityManager.remove(car);
					entityTransaction.commit();
					System.out.println("Car removed sucessfully!!");
					closeConnection();
				} else {
					System.out.println("Car with id-" + id + " does not exist!");
				}
			} catch (Exception e) {
				System.out.println("Car does not exist!");
				System.out.println("Please enter a valid id!");
				scanner.nextLine();
				continue;
			}
			break;
		}
	}

	private static void editCar() {
		while (true) {
			try {
				openConnection();
				entityTransaction.begin();
				System.out.print("Enter the car id: ");
				int id = scanner.nextInt();
				CarDTO car = entityManager.find(CarDTO.class, id);
				if (id == car.getId()) {
					System.out.println("What do you want to edit?");
					System.out
							.print("1.Name\n" + "2.Model\n" + "3.Brand\n" + "4.FuelType\n" + "5.Color\n" + "6.Price\n");
					System.out.print("Enter your choice: ");
					int choice = scanner.nextInt();
					switch (choice) {
					case 1:
						System.out.print("Enter the new car name: ");
						String name = scanner.next();
						car.setName(name);
						entityManager.persist(car);
						entityTransaction.commit();
						System.out.println("Car name edited sucessfully!!");
						closeConnection();
						break;
					case 2:
						System.out.print("Enter the model name: ");
						String model = scanner.next();
						car.setModel(model);
						entityManager.persist(car);
						entityTransaction.commit();
						System.out.println("Model name edited successfully!!");
						closeConnection();
						break;
					case 3:
						System.out.print("Enter the brand name: ");
						String brand = scanner.next();
						car.setBrand(brand);
						entityManager.persist(car);
						entityTransaction.commit();
						System.out.println("Brand name edited successfully!!");
						closeConnection();
						break;
					case 4:
						System.out.print("Enter the fuelType: ");
						String fuelType = scanner.next();
						car.setFuelType(fuelType);
						entityManager.persist(car);
						entityTransaction.commit();
						System.out.println("FuelType edited successfully!!");
						closeConnection();
						break;
					case 5:
						System.out.print("Enter the color: ");
						String color = scanner.next();
						car.setColor(color);
						entityManager.persist(car);
						entityTransaction.commit();
						System.out.println("Color edited successfully!!");
						closeConnection();
						break;
					case 6:
						System.out.print("Enter the price: ");
						double price = scanner.nextDouble();
						car.setPrice(price);
						entityManager.persist(car);
						entityTransaction.commit();
						System.out.println("Price edited successfully!!");
						closeConnection();
						break;
					default:
						System.out.println("Invalid choice!");
						break;
					}
				}
			} catch (NullPointerException e) {
				System.out.println("Car does not exist!");
				System.out.println("Please enter a valid id!");
				scanner.nextLine();
				continue;
			}
			break;
		}

	}

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("car");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private static void closeConnection() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}

}
