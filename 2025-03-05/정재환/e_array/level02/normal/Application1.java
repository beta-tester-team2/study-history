package com.ohgiraffers.e_array.level02.normal;

import java.util.Scanner;

public class Application1 {

	public static void main(String[] args) {
		
		/* 문자열을 하나 입력받아 문자 자료형 배열로 바꾼 뒤
		 * 검색할 문자를 하나 입력 받아 
		 * 입력 받은 검색할 문자가 문자열에 몇개 있는지를 출력하세요
		 * 
		 * -- 입력 예시 --
		 * 문자열을 하나 입력하세요 : helloworld
		 * 검색할 문자를 입력하세요 : l
		 * 
		 * -- 출력 예시 --
		 * 입력하신 문자열 helloworld에서 찾으시는 문자 l은 3개 입니다.
		 * */
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 하나 입력하세요 : ");
		String input = sc.nextLine();
		String[] strarr = input.split("");
		System.out.print("검색할 문자를 입력하세요 : ");
		String searchStr = sc.nextLine();
		int count = 0;
		for (int i = 0; i < strarr.length; i++) {
			if (strarr[i].equals(searchStr)) {
				count++;
			}
		}
		System.out.println("입력하신 문자열 " + input +"에서 찾으시는 문자" + searchStr + "은 " + count +"개 입니다.");
	}
}
