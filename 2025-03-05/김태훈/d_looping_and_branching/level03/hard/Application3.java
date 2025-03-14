package com.ohgiraffers.d_looping_and_branching.level03.hard;

import java.io.*;

public class Application3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		System.out.print("문자열 입력 : ");
		String word = br.readLine();
		System.out.print("문자 입력 : ");
		String alphabet = br.readLine();

		int cnt = 0;
		boolean isAlpha = true;

		if(!word.matches("[a-zA-Z]+")){
			System.out.println("영문자가 아닌 문자가 포함되어 있습니다.");
			return;
		}


		for (int i = 0; i < word.length(); i++) {
			if(alphabet.equals(String.valueOf(word.charAt(i)))){
				cnt++;
			}

		}
		System.out.println("포함된 갯수 : " + cnt);


		/* 문자열을 하나 입력 받고, 검색할 문자를 입력 하여
		 * 입력받은 문자열에서 검색할 문자가 몇 개 포함되어 있는지를 출력하는 프로그램을 만드세요
		 *
		 * 단, 문자열에 영문자가 아닌 문자가 섞여 있는 경우에는
		 * 검색할 문자를 입력받지 않고 "영문자가 아닌 문자가 포함되어 있습니다." 출력 후 프로그램을 종료하세요
		 *
		 * 또한 일치하는 문자의 경우 대소문자를 구분합니다.
		 *
		 * -- 프로그램 예시 --
		 *
		 * -- 정상 동작의 경우 --
		 * -- 입력 예시 --
		 * 문자열 입력 : apple
		 * 문자 입력 : p
		 *
		 * -- 출력 예시 --
		 * 포함된 갯수 : 1개
		 *
		 * --------------------
		 * -- 영문자가 아닌 문자 포함된 경우 --
		 * -- 입력 예시 --
		 * 문자열 입력 : app2le
		 *
		 * -- 출력 예시 --
		 * 영문자가 아닌 문자가 포함되어 있습니다.
		 * */

	}
}
