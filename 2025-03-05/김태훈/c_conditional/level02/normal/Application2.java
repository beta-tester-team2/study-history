package com.ohgiraffers.c_conditional.level02.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("몸무게를 입력해 주십시오.");
		double kg = Double.parseDouble(br.readLine());
		System.out.println("키를 입력해 주십시오. ex)1.8");
		double m = Double.parseDouble(br.readLine());

		double bmi = kg / (m * m);

		if (bmi < 20) {
			System.out.println("당신은 저체중 입니다.");
		} else if (bmi >= 20 && bmi < 25) {
			System.out.println("당신은 정상체중 입니다.");
		} else if (bmi >= 25 && bmi < 30) {
			System.out.println("당신은 과체중 입니다.");
		} else if (bmi >= 30) {
			System.out.println("당신은 비만 입니다.");
		}
		/* BMI(신체질량지수)를 계산하고, 계산된 값에 따라 
		 * 저체중(20 미만)인 경우 "당신은 저체중 입니다.", 
		 * 정상체중(20이상 25미만)인 경우 "당신은 정상체중 입니다.", 
		 * 과제충(25이상 30미만)인 경우 "당신은 과체중 입니다.", 
		 * 비만(30이상)인 경우 "당신은 비만 입니다." 를  출력하세요
		 * 
		 * BMI 계산 방법은 체중(kg) / (신장(m) * 신장(m)) 이다.
		 * 
		 * 계산 예시) BMI = 67 / (1.7 * 1.7)
		 * */
		
	}
}
