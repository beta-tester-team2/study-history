package com.ohgiraffers.c_conditional.level03.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application2 {
	
	public static void main(String[] args) {
		
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
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> map = new HashMap<>();
		map.put("apple", 1000);
		map.put("banana", 3000);
		map.put("melon", 2000);
		map.put("grape", 5000);
		System.out.println("--상품 가격--");
		System.out.println("apple : " + map.get("apple") + "원");
		System.out.println("banana : " + map.get("banana") + "원");
		System.out.println("melon : " + map.get("melon") + "원");
		System.out.println("grape : " + map.get("grape") + "원");
		System.out.print("과일 이름을 입력하세요 : ");
		String input = sc.nextLine();
		if (!map.containsKey(input)) {
			System.out.println("준비된 상품이 없습니다.");
		} else {
			System.out.println(input + "의 가격은 " + map.get(input) + "원입니다.");
		}
	}
}
