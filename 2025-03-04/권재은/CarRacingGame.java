import java.util.Scanner;

/*
1. 기어 종류: P(주차), R(후진), N(중립), D(주행) 추가
2. 기어 상태를 변경할 수 있도록 기능 추가
3. 기어 상태에 따라 자동차의 동작 변경
    P(주차): 가속 불가
    R(후진): 후진 가속
    N(중립): 가속 불가
    D(주행): 직진 가속
 */

class Car {

    private boolean on = false;
    private int speed = 0;
    private String gear = "P";

    public void start() {
        if (on) {
            System.out.println("이미 자동차 시동이 걸려있습니다.");
        } else {
            on = true;
            System.out.println("자동차 시동이 걸렸습니다.");
        }
    }

    public void gearChange(String newGear) {
        if (!on) {
            System.out.println("자동차가 꺼져있어 기어변속이 불가능합니다.");
            return;
        }
        if (!newGear.equals('P') && !newGear.equals("R") && !newGear.equals("N") && !newGear.equals("D")) {
            System.out.println("잘못된 기어변속입니다. P, R, N, D 중 선택해주세요.");
            return;
        }
        if (speed > 0 && newGear.equals("P")) {
            System.out.println("자동차가 달리는 중엔 Parking 으로 변속할 수 없습니다.");
            return;
        }
        gear = newGear;
        System.out.println("기어가 " + gear +"로 변속되었습니다.");
    }

    public void accel() {
        if (!on) {
            System.out.println("자동차가 꺼져있습니다.");
            return;
        }
        if (gear.equals("P")||gear.equals("N")) {
            System.out.println("기어를 D또는 R로 변경해야 주행이 가능합니다.");
            return;
        }
        if (gear.equals("D")){
            speed += 10;
            System.out.println("진진 가속, 자동차의 현재 속도: " + speed + "km/h");
        }
        else if (gear.equals("R")){
            speed -= 10;
            System.out.println("후진 가속, 자동차의 현재 속도: " + speed + "km/h");
        }
    }

    public void brake() {
        if (speed != 0) {
            speed = 0;
            System.out.println("자동차가 멈췄습니다.");
        } else {
            System.out.println("자동차가 이미 멈춰있습니다.");
        }
    }

    public void stop() {
        if (speed > 0) {
            System.out.println("자동차가 달리는 중이라 시동을 끌 수 없습니다.");
        } else if (on) {
            on = false;
            System.out.println("자동차 시동이 꺼졌습니다.");
        } else {
            System.out.println("자동차가 이미 꺼져있습니다.");
        }

    }
}

class Racer {
    private Car car = new Car();

    public Racer (Car car){
        this.car = car;
    }
    public void gearChange(String gear) {
        car.gearChange(gear);
    }
    public void start() {
        car.start();
    }
    public void accel() {
        car.accel();
    }
    public void brake() {
        car.brake();
    }
    public void stop() {
        car.stop();
    }
}

public class CarRacingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car car = new Car();
        Racer racer = new Racer(car);
        boolean run = true;

        System.out.println("\n======== 카레이싱 프로그램 ==========");
        System.out.println("1. 시동 걸기");
        System.out.println("2. 엑셀레이터 밟기");
        System.out.println("3. 브레이크 밟기");
        System.out.println("4. 시동 끄기");
        System.out.println("5. 종료");

        while(run){
            System.out.println("\n원하는 번호를 선택하세요: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    racer.start();
                    break;
                case 2:
                    boolean complete = false;
                    sc.nextLine();

                    while(!complete){
                        System.out.println("P, R, N, D 중 변속할 기어를 입력해주세요.: ");
                        String gear = sc.nextLine().trim().toUpperCase();

                        if (gear.isEmpty()) {
                            System.out.println("아무 입력도 받지 않았습니다. 다시 입력해주세요.");
                            continue;
                        }

                        if (gear.equals('P') && gear.equals("R") && gear.equals("N") && gear.equals("D")){
                            racer.gearChange(gear);
                            complete = true;
                        }
                        else{
                            System.out.println("잘못된 입력입니다. 다시 기어 변속을 선택하세요.");
                        }
                    }
                    break;
                case 3:
                    racer.accel();
                    break;
                case 4:
                    racer.brake();
                    break;
                case 5:
                    racer.stop();
                    break;
                case 6:
                    System.out.println("시스템을 종료합니다.");
                    run = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 1~5 숫자중에 다시 선택하세요.");
            }
        }
        sc.close();
    }
}