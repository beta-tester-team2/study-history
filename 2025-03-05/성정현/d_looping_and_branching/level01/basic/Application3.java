package com.ohgiraffers.d_looping_and_branching.level01.basic;

import java.util.Scanner;

public class Application3 {

	public static void main(String[] args) {
		
		/* 1부터 입력받은 정수까지의 짝수의 합을 구하세요
		 * 
		 * -- 입력 예시 --
		 * 정수를 입력하세요 : 10
		 * 
		 * -- 출력 예시 --
		 * 1부터 10까지 짝수의 합 : 30
		 * */
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		int result = 0;
		for(int i = 1; i <= input; i++){
			if(i % 2 == 1)
				continue;
			result += i;
		}
		System.out.println(result);
	}

}
