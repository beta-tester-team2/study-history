package com.ohgiraffers.section03.abstraction;

public class CarRacer {
    private final Car car = new Car();

    public void startUp() {
        car.startCar();
    }
    public void stepAccelator(){
        car.moveCar();
    }
    public void stepBreak(){
        car.stopCar();
    }
    public void turnOff(){
        car.turnOff();
    }
    public void switchGear(GearStatus gearStatus) {
        car.switchGear(gearStatus);
    }

    public void moveBack() {
        car.moveBack();
    }
}
