package com.altair.car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        CarRacer carRacer = new CarRacer();
        Gear gear;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("카레이스 프로그램을 시작합니다.");
        while(true){
            System.out.println("사용할 프로그램을 입력해 주십시오.");
            System.out.println("--------------------");
            System.out.println("1. 시동 걸기");
            System.out.println("2. 전진");
            System.out.println("3. 후진");
            System.out.println("4. 정지");
            System.out.println("5. 시동끄기");
            System.out.println("6. 기어 P");
            System.out.println("7. 기어 N");
            System.out.println("8. 기어 D");
            System.out.println("9. 기어 R");
            System.out.println("10. 프로그램 종료");
            System.out.print("메뉴 선택 : ");
            int choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1: carRacer.startUp(); break;
                case 2: carRacer.go(); break;
                case 3: carRacer.reverse(); break;
                case 4: carRacer.stop(); break;
                case 5: carRacer.turnOff(); break;
                case 6: carRacer.changeGear(Gear.PARKING); break;
                case 7: carRacer.changeGear(Gear.NEUTRAL); break;
                case 8: carRacer.changeGear(Gear.DRIVE); break;
                case 9: carRacer.changeGear(Gear.REVERRSE); break;
                case 10: System.out.println("프로그램을 종료합니다."); break;
                default: System.out.println("기입되지 않은 메뉴입니다."); break;
            }

            if (choice == 10) {
                break;
            }

        }
    }
}
