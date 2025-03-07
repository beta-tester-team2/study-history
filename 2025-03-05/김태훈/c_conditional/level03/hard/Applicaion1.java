package com.ohgiraffers.c_conditional.level03.hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Applicaion1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("첫 번째 정수 : ");
		int a = Integer.parseInt(br.readLine());
		System.out.print("두 번째 정수 : ");
		int b = Integer.parseInt(br.readLine());
		System.out.print("연산 기호를 입력하세요 : ");
		char cal = br.readLine().charAt(0);

        switch (cal) {
            case '+' -> System.out.println(a + " + " + b + " = " + (a + b));
            case '-' -> System.out.println(a + " - " + b + " = " + (a - b));
            case '*' -> System.out.println(a + " * " + b + " = " + (a * b));
			case '/' -> System.out.println(a + " / " + b + " = " + (a / b));
			case '%' -> System.out.println(a + " % " + b + " = " + (a % b));
			default -> System.out.println("입력하신 연산은 없습니다. 프로그램을 종료합니다.");
            }
        }
		/* 두 개의 정수를 입력 받아 변수에 저장하고,
		 * 연산기호(+, -, *, /, %)를 입력 받아 해당 연산의 수행 결과를 출력하세요.
		 * 단, 준비된 연산기호 외의 문자를 입력하는 경우 "입력하신 연산은 없습니다. 프로그램을 종료합니다." 출력 후 프로그램 종료
		 * 
		 * -- 입력 예시 --
		 * 첫 번째 정수 : 4
		 * 두 번째 정수 : 3
		 * 연산 기호를 입력하세요 : +
		 * 
		 * -- 출력 예시 --
		 * 4 + 3 = 7 
		 */
		
	}

