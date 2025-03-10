package org.example.Week3Homework;






abstract class Car implements Vehicle {
    protected final double fuelTankSize;
    protected final String fuelType;
    protected final int gears = 6;
    protected final double consumptionPer100Km;
    protected double availableFuel;
    protected final int tireSize;
    protected final String chassisNumber;
    protected int currentGear = 1;
    protected double fuelConsumed = 0;

    public Car(double fuelTankSize, String fuelType, double consumptionPer100Km, double availableFuel, int tireSize, String chassisNumber) {
        this.fuelTankSize = fuelTankSize;
        this.fuelType = fuelType;
        this.consumptionPer100Km = consumptionPer100Km;
        this.availableFuel = availableFuel;
        this.tireSize = tireSize;
        this.chassisNumber = chassisNumber;
    }
    @Override
    public void start() {
        fuelConsumed = 0; // Reset stats on start
    }
    @Override
    public void stop() {
        availableFuel -= fuelConsumed;
    }
    @Override
    public void drive(double kilometers) {
        double actualConsumption = consumptionPer100Km * (1 + ((tireSize - 15) * 0.05));
        actualConsumption *= (1 - (currentGear - 1) * 0.1);
        fuelConsumed += (kilometers / 100) * actualConsumption;
    }
    public void shiftGear(int gear) {
        if (gear >= 1 && gear <= gears) {
            currentGear = gear;
        }
    }
    public double getAvailableFuel() {
        return availableFuel;
    }
    public double getAverageFuelConsumption() {
        return fuelConsumed * 100;
    }
}