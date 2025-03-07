package com.ohgiraffers.d_looping_and_branching.level01.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("정수를 입력하세요 : ");
		int num = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("1부터 " + num + "까지 짝수의 합 : " + sum);
		/* 1부터 입력받은 정수까지의 짝수의 합을 구하세요
		 *
		 * -- 입력 예시 --
		 * 정수를 입력하세요 : 10
		 *
		 * -- 출력 예시 --
		 * 1부터 10까지 짝수의 합 : 30
		 * */

	}

}
