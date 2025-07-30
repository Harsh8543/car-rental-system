package com.example.credential;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRentalService {
    private List<Car> cars = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Rental> rentals = new ArrayList<>();

    public CarRentalService() {
        cars.add(new Car("C001", "Toyota", "Camry", 60));
        cars.add(new Car("C002", "Honda", "Accord", 70));
        cars.add(new Car("C003", "Mahindra", "Thar", 150));
    }

    public List<Car> getAvailableCars() {
        return cars.stream().filter(Car::isAvailable).collect(Collectors.toList());
    }

    public String rentCar(String carId, String customerName, int days) {
        Car car = cars.stream().filter(c -> c.getCarId().equals(carId) && c.isAvailable()).findFirst().orElse(null);
        if (car == null) return "Car not available.";

        Customer customer = new Customer("CUS" + (customers.size() + 1), customerName);
        customers.add(customer);

        car.setAvailable(false);
        rentals.add(new Rental(car, customer, days));

        return "Car rented to " + customerName + ". Total price: $" + car.calculatePrice(days);
    }

    public String returnCar(String carId) {
        Car car = cars.stream().filter(c -> c.getCarId().equals(carId) && !c.isAvailable()).findFirst().orElse(null);
        if (car == null) return "Car not found or not rented.";

        car.setAvailable(true);
        rentals.removeIf(r -> r.getCar().equals(car));
        return "Car returned successfully.";
    }
}
