/*
 * 카레이서 예제
 * Car.java
 */
package car.racing;

enum GearStatus {
    // 기어 열거형
    PARKING('P'),
    REVERSE('R'),
    NEUTRAL('N'),
    DRIVE('D');

    final private char gear;
    private GearStatus(char ch) {
        this.gear = ch;
    }
    public char getSymbol() {
        return this.gear;
    }
}

public class Car {

    private boolean isSeated = false;
    private String model; // 차 모델
    private GearStatus gearStatus = GearStatus.PARKING; // 현재 기어
    private boolean isStarted; // 시동 여부
    private double speed; // 현재 속력

    // 기어 올리는 메소드
    public void gearUp() {
        switch (this.gearStatus) {
            case PARKING:
                this.gearStatus = GearStatus.REVERSE;
                System.out.println("R 기어로 올립니다.");
                break;
            case REVERSE:
                this.gearStatus = GearStatus.NEUTRAL;
                System.out.println("N 기어로 올립니다.");
                break;
            case NEUTRAL:
                this.gearStatus = GearStatus.DRIVE;
                System.out.println("D 기어로 올립니다.");
                break;
            default:
                System.out.println("더 이상 올릴 수 없습니다.");
                break;
        }
    }

    // 기어 내리는 메소드
    public void gearDown() {
        switch (this.gearStatus) {
            case DRIVE:
                this.gearStatus = GearStatus.NEUTRAL;
                System.out.println("N 기어로 내립니다.");
                break;
            case NEUTRAL:
                this.gearStatus = GearStatus.REVERSE;
                System.out.println("R 기어로 내립니다.");
                break;
            case REVERSE:
                this.gearStatus = GearStatus.PARKING;
                System.out.println("P 기어로 내립니다.");
                break;
            default:
                System.out.println("더 이상 내릴 수 없습니다.");
                break;
        }
    }

    // 차 모델을 설정하는 메소드
    public void setModel(String model) {
        this.model = model;
    }

    // 시동 거는 메소드
    public void turnOn() {
        if (isStarted) {
            // 시동걸린 상태
            System.out.println("이미 시동이 걸려 있습니다.");
        } else {
            // 시동 걸기 가능
            this.isStarted = true;
            System.out.println("시동을 걸었습니다.");
        }
    }

    // 엑셀밟는 메소드
    public void pushAccelerator() {
        if (isStarted) {
            // 시동걸린 상태
            switch (gearStatus) {
                case PARKING:
                    System.out.println("현재 P 기어입니다. 움직이지 않습니다.");
                    break;

                case REVERSE:
                    this.speed += 10;
                    if (this.speed > 300) this.speed = 300;
                    System.out.printf("차가 후진합니다. (현재 속력 : %.2fkm/h)\n", this.speed);
                    break;

                case NEUTRAL:
                    System.out.println("현재 중립상태입니다. 움직이지 않습니다.");
                    break;

                case DRIVE:
                    this.speed += 10;
                    if (this.speed > 300) this.speed = 300;
                    System.out.printf("차가 전진합니다. (현재 속력 : %.2fkm/h)\n", this.speed);
                    break;
            }
        } else {
            // 시동 안걸린 상태
            System.out.println("먼저 시동을 걸어주세요.");
        }
    }

    // 차를 멈추는 메소드
    public void pushBreak() {
        if (isStarted) {
            // 시동걸린 상태
            if (this.speed > 0) {
                this.speed = 0;
                System.out.println("차를 멈췄습니다.");
            } else {
                System.out.println("차가 이미 멈춰있습니다.");
            }
        } else {
            // 시동 안걸린 상태
            System.out.println("먼저 시동을 걸어주세요.");
        }
    }

    // 시동 끄는 메소드
    public void turnOff() {
        if (isStarted) {
            // 시동걸린 상태
            if (this.speed > 0) {
                System.out.println("차를 먼저 멈춰주세요.");
            } else {
                this.isStarted = false;
                System.out.println("시동을 껐습니다.");
            }
        } else {
            // 시동 안걸린 상태
            System.out.println("이미 시동이 꺼져있습니다.");
        }
    }

    // 차 모델 이름을 가져오는 메소드
    public String getModel() {
        return this.model;
    }

    public boolean getSeated() {
        return this.isSeated;
    }
}
