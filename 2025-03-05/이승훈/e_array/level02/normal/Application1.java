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
		Scanner scanner = new Scanner(System.in);
		System.out.print("문자열을 하나 입력하세요 : ");
		String str = scanner.nextLine();
		System.out.print("검색할 문자를 입력하세요 : ");
		char ch = scanner.nextLine().charAt(0);
		char[] strArr = str.toCharArray();
		int cnt = 0;
		for (char c: strArr) {
			if (c == ch) cnt++;
		}
		System.out.printf("입력하신 문자열 %s에서 찾으시는 문자 %c은 %d개 입니다.\n", str, ch, cnt);
	}
}
