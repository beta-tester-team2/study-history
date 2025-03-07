package com.altair.car;

public class CarRacer {
    private final Car car = new Car();
    private Gear gear;

    public void startUp(){
        car.startUp();
    }
    public void go(){
        car.go();
    }
    public void reverse(){
        car.reverse();
    }
    public void stop(){
        car.stop();
    }
    public void turnOff(){
        car.turnOff();
    }
    public void changeGear(Gear newGear){
        car.changeGear(newGear);
    }

}
