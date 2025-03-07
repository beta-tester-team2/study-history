package com.ohgiraffers.c_conditional.level03.hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("과일 이름을 입력하세요 : ");
		String fruit = br.readLine();

		switch (fruit) {
			case "apple" -> System.out.println(fruit + "의 가격은 1000원 입니다.");
			case "banana" -> System.out.println(fruit + "의 가격은 3000원 입니다.");
			case "melon" -> System.out.println(fruit + "의 가격은 2000원 입니다");
			case "grape" -> System.out.println(fruit + "의 가격은 5000원 입니다.");
			default -> System.out.println("준비된 상품이 없습니다.");
		}
		/* 과일 이름("apple", "banana", "melon", "grape") 중 한 가지를 문자열로 입려하면
		 * 해당하는 가격에 맞게 상품명과 가격이 출력되게 하세요.
		 * 단, 목록에 없는 과일을 입력 시 "준비된 상품이 없습니다." 출력 후 프로그램 종료
		 * 
		 * -- 상품 가격 --
		 * apple :  1000원
		 * banana : 3000원
		 * melon : 2000원
		 * grape : 5000원
		 * 
		 * -- 입력 예시 --
		 * 과일 이름을 입력하세요 : banana
		 * 
		 * -- 출력 예시 --
		 * banana의 가격은 3000원 입니다.
		 * */
		
	}
}
