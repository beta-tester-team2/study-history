/*
 * 카레이서 예제
 * CarRacer.java
 */
package car.racing;

public class CarRacer {

    private String racerName;
    private Car car = new Car();

    public void setName(String name) {
        this.racerName = name;
    }

    public String getName() {
        return this.racerName;
    }

    public void turnOn() {
        car.turnOn();
    }

    public void pushAccelerator() {
        car.pushAccelerator();
    }

    public void pushBreak() {
        car.pushBreak();
    }

    public void turnOff() {
        car.turnOff();
    }

    public void gearUp() {
        car.gearUp();
    }

    public void gearDown() {
        car.gearDown();
    }
}
