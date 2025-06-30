package chap02_method_parameter;

import java.util.Arrays;

/*
 * 메소드 형식
 * 반환타입 메소드명(매개변수1, 매개변수2, ...) {
 * 메소드 본문 코드
 * return 반환값
 * }
 * 
 * 메소드명 calmelCase
 */


public class Parameter {
	
	/**
	 * @param 없음 
	 */
	void methodA() {
		System.out.println("methodA");
		
	}
	/**
	 * 
	 * @param x 정수를 전달받음 
	 */
	void methodB(int x) {
		System.out.println("methodB" + x);
	}
	
	/**
	 * 
	 * @param items 정수형 배열을 전달받음
	 */
	void methodC(int[] items) {
	  System.out.println("methodC" + Arrays.toString(items));
	}
	
	/**
	 * 
	 * @param items 가변 인자이므로 0개 이상의 정수값을 전달받음(int[]과 동일하게 동작)
	 */
	void methodD(int... items) {
	  System.out.println("methodD" + Arrays.toString(items));
	}
	
	// 1개 이상의 정수 값을 전달 받는 메소드E 만들어보기
	void methodE(int first, int... rest) {
	  System.out.println("methodE" + first);
	  System.out.println("methodE" + Arrays.toString(rest));
	}
	/**
	 * 기본 타입과 참조 타입의 동작을 비교하기 위한 메소드
	 * @param number
	 * @param numbers
	 */
	void methodF(int number, int[] numbers) {
	  number = 10;
	  numbers[0] = 1;
	  numbers[1] = 2;
	  numbers[2] = 3;
	}
	
	void methodG(Car car, String region) {
	  car.drive(region);
	}

}
