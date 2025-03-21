package com.ohgiraffers.d_looping_and_branching.level02.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문자열을 입력하세요 : ");
		String word = br.readLine();
		for (int i = 0; i < word.length(); i++) {
			System.out.println(i + " : " + word.charAt(i));
		}

		/* 문자열을 입력 받아서 문자열의 각 인덱스별로 한 글자씩 출력하세요
		 *
		 * 참고) 문자열의 길이는 String 클래스의 length() 메소드를 이용할 수 있습니다.
		 *
		 * -- 입력 예시 --
		 * 문자열을 입력하세요 : apple
		 *
		 * -- 출력 예시 --
		 * 0 : a
		 * 1 : p
		 * 2 : p
		 * 3 : l
		 * 4 : e
		 * */

	}

}
