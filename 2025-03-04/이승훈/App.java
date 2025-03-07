/*
 * 카레이서 예제
 * App.java
 */
package car.racing;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car[] garage = new Car[3];
        garage[0].setModel("Huracán");
        garage[1].setModel("Urus");
        garage[2].setModel("Revuelto");
        CarRacer racer = new CarRacer();
        System.out.print("레이서의 이름을 정해주세요 : ");
        String racerName = sc.nextLine();
        racer.setName(racerName);
        System.out.printf("%s님의 시뮬레이션을 시작합니다.\n", racer.getName());
        while(true) {
			System.out.println("======== 카레이싱 프로그램 ==========");
			System.out.println("1. 시동 걸기");
            System.out.println("2. 기어 올리기");
            System.out.println("3. 기어 내리기");
			System.out.println("4. 액셀러레이터 밟기");
			System.out.println("5. 브레이크 밟기");
			System.out.println("6. 시동 끄기");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			int no = sc.nextInt();
			
			switch (no) {
				case 1 : racer.turnOn(); break;
                case 2 : racer.gearUp(); break;
                case 3 : racer.gearDown(); break;
				case 4 : racer.pushAccelerator(); break;
				case 5 : racer.pushBreak(); break;
				case 6 : racer.turnOff(); break;
				case 9 : System.out.println("프로그램을 종료합니다."); break;
				default : System.out.println("잘못된 번호를 선택하셨습니다."); break;
			}
			
			if (no == 9) {
                sc.close();
				break;
			}
		}
    }
}
