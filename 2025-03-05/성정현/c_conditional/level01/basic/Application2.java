package com.ohgiraffers.c_conditional.level01.basic;

import java.util.Scanner;

public class Application2 {

	public static void main(String[] args) {
		
		/* 정수를 입력 받아 그 수가 짝수인지 홀수인지 판단해서 결과를 출력하세요
		 * 짝수인 경우 "짝수다." 출력, 홀수인 경우 "홀수다." 출력 
		 * 
		 * -- 입력 예시 --
		 * 정수를 하나 입력하세요 : 5
		 * 
		 * -- 출력 예시 --
		 * 홀수다.
		 * */
		Scanner scanner = new Scanner(System.in);

		System.out.print("정수를 하나 입력하세요 : ");
		int input = scanner.nextInt();

		System.out.println((input % 2 == 1)?"홀수입니다!":"짝수입니다.");
	}
}
