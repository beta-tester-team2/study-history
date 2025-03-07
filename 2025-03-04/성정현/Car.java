package com.ohgiraffers.section03.abstraction;

public class Car {
	
	private boolean isOn;
	private int speed;

	public void startUp() {
		if(isOn) {
			System.out.println("이미 시동이 걸려 있습니다.");
		} else {
			this.isOn = true;
			System.out.println("시동을 걸었습니다.");
		}
	}

	public void go() {
		if(isOn) {
			System.out.println("차가 전진합니다.");
			if (this.speed < 0) {
				this.speed = 0;
			}
			this.speed += 10;
			System.out.println("시속 "+ this.speed +"km/h");
		} else {
			System.out.println("시동을 먼저 걸어주세요.");
		}
		
	}

	public void back() {
		if(isOn) {
			System.out.println("차가 후진합니다.");
			if (this.speed > 0) {
				this.speed = 0;
			}
			this.speed -= 10;
			System.out.println("시속 "+ this.speed +"km/h");
		} else {
			System.out.println("시동을 먼저 걸어주세요.");
		}

	}

	public void stop() {
		if(isOn) {
			if(this.speed > 0) {
				this.speed = 0;
				System.out.println("브레이크를 밟았습니다. 차를 멈춥니다.");
			} else {
				System.out.println("차는 이미 멈춰있는 상태입니다.");
			}
		} else {
			System.out.println("시동을 먼저 걸어주세요.");
		}
	}

	public void turnOff() {
		if(isOn) {
			if(speed > 0) {
				System.out.println("차를 멈춘뒤에 시동을 끌 수 있습니다.");
			} else {
				this.isOn = false;
				System.out.println("시동을 끕니다.");
			}
		} else {
			System.out.println("시동이 꺼져있습니다.");
		}
	}
}
