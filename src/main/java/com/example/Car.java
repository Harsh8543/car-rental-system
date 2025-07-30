package com.example.credential;

public class Car {
    private String carId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean available = true;

    public Car(String carId, String brand, String model, double price) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = price;
    }

    public String getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double calculatePrice(int days) {
        return basePricePerDay * days;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
