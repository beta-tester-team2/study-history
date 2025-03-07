package com.ohgiraffers.section03.abstraction;

public class Car {
    private boolean isOn;
    private int speed;
    private int num;
    private GearStatus gearStatus;
    public void startCar() {
        if (isOn) {
            System.out.println("이미 시동이 걸려있습니다.");
        } else {
            this.isOn = true;
            System.out.println("시동을 걸었습니다.");
        }
    }
    public void moveCar() {
        if (isOn && gearStatus == GearStatus.DRIVE) {
            System.out.println("앞으로 갑니다.");
            this.speed += 10;
            System.out.println("현재 속력 : " + this.speed + "km");
        } else if(!isOn){
            System.out.println("시동을 걸어주십시오.");
        }else{
            System.out.println("기어를 DRIVE 상태로 해주십시오.");
        }
    }
    public void stopCar() {
        if (isOn) {
            if (speed > 0) {
                System.out.println("차를 멈춥니다.");
                this.speed = 0;
            } else {
                System.out.println("이미 정지 상태입니다.");
            }
        } else {
            System.out.println("시동을 걸어주십시오.");
        }
    }
    public void turnOff(){
        if(isOn){
            this.isOn = false;
            System.out.println("시동을 끕니다.");
        } else{
            System.out.println("이미 시동을 끈 상태입니다.");
        }
    }
    public void switchGear(GearStatus newGearStatus) {
        if (isOn) {
            this.gearStatus = newGearStatus;
            System.out.println("기어를 " + newGearStatus + " 상태로 바꿉니다.");
        } else {
            System.out.println("시동을 걸어주십시오.");
        }
    }
    public void moveBack(){
        if (isOn) {
            if (gearStatus == GearStatus.REVERSE) {
                System.out.println("차가 후진합니다.");
            } else {
                System.out.println("기어를 REVERSE 상태로 해주십시오.");
            }
        } else {
            System.out.println("시동을 걸어주십시오.");
        }
    }
    public GearStatus getGearStatus() {
        return gearStatus;
    }
}
