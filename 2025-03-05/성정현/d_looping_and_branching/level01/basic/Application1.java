package com.ohgiraffers.d_looping_and_branching.level01.basic;

public class Application1 {

	public static void main(String[] args) {
		
		/* 1부터 10까지 합계를 구하고 결과를 출력하세요
		 * 
		 * -- 출력 예시 --
		 * 1부터 10까지의 합 : 55
		 * */

		int result = 0;
		for(int i = 0; i <= 10; i++){
			result += i;
		}
		System.out.println(result);
	}
}
