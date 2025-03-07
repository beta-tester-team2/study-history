package com.altair.car;
public class Car {
    private boolean isOn;
    private int speed;
    private Gear currentGear = Gear.PARKING;

    public void startUp(){
        if(isOn){
            System.out.println("이미 시동이 걸렸습니다.");
        } else if(currentGear != Gear.PARKING){
            System.out.println("기어가 P에 위치해야합니다.");
        } else{
            this.isOn = true;
            System.out.println("시동을 걸었습니다.");
        }
    }

    public void go(){
        if(isOn && currentGear == Gear.DRIVE){
            System.out.println("앞으로 전진합니다.");
            this.speed += 10;
            System.out.println("현재 시속은 " + this.speed + "km/h 입니다.");
        }else if(!isOn){
            System.out.println("시동이 걸려있지 않습니다. 시동을 걸어 주십시오.");
        }else{
            System.out.println("기어를 D에 위치시켜주십시오.");
        }
    }

    public void stop(){
        if (isOn) {
            if(this.speed > 0){
                System.out.println("브레이크를 감지했습니다. 속도를 줄입니다.");
                this.speed -= 10;
                System.out.println("현재 시속은 " + this.speed + "km/h 입니다.");
            }else {
                System.out.println("정차 상태 입니다.");
            }
        } else {
            System.out.println("시동이 걸려있지 않습니다. 시동을 걸고 다시 시도해주십시오.");
        }
    }

    public void reverse(){
        if(isOn){
            if(this.speed == 0 && currentGear == Gear.REVERRSE){
                System.out.println("후진합니다.");
                this.speed += 10;
            }else if(!isOn){
                System.out.println("시동이 걸려있지 않습니다. 시동을 걸어 주십시오.");
            }else {
                System.out.println("기어를 R에 위치시켜주십시오.");
            }
        }
    }

    public void turnOff(){
        if(isOn){
            if(this.speed > 0){
                System.out.println("주행 중에는 시동을 끌 수 없습니다. 정차 후 시도해주십시오.");
            }else{
                this.isOn = false;
                System.out.println("시동을 끕니다.");
            }
        }else {
            System.out.println("이미 시동이 꺼져있습니다.");
        }
    }

    public void changeGear(Gear newGear){
        if(!isOn && newGear != Gear.PARKING){
            System.out.println("시동을 켜야합니다.");
        }

        if(this.speed > 0){
            System.out.println("기어 변동을 위해서는 정차 해야 합니다.");
        }else{
            currentGear = newGear;
            System.out.println("기어가 " + newGear + "(으)로 변경되었습니다.");
        }

    }

}
