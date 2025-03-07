package com.ohgiraffers.b_operator.level01;

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

        int a = 20;
        int b = 10;
        System.out.printf("두 수 중 큰 수는 %d입니다.\n", a > b ? a : b);
    }

}
