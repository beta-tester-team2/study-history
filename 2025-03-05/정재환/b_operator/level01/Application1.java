package com.ohgiraffers.b_operator.level01;

import java.util.Scanner;

public class Application1 {

    public static void main(String[] args) {

        /* 두 개의 정수형 변수를 선언하고, 삼항 연산자를 사용하여
         * 두 수 중 큰 수를 출력하는 프로그램을 작성해본다.
         *
         *
         * -- 출력 예시 --
         *
         * 두 수 중 큰 수는 20입니다.
         *
         * */
        Scanner sc = new Scanner(System.in);
        System.out.println("두 수를 입력하세요.");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println("두 수 중 큰 수는 " + (num1 > num2 ? num1 : num2) + "입니다.");
    }

}
