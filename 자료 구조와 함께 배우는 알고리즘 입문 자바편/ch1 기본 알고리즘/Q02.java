/*
 * 연습문제 Q2
 * 세 값의 최솟값을 구하는 min3 메서드를 작성하세요.
 */

public class Q02 {
	static int min3(int a, int b, int c) {
		int min = a;
		
		if (b < min) min = b;
		if (c < min) min = c;
		
		return min;
	}
	
	public static void main(String[] args) {
		System.out.println("min3(1,2,3) = " + min3(1,2,3));
		System.out.println("min3(5,2,3) = " + min3(5,2,3));
		System.out.println("min3(3,7,3) = " + min3(3,7,3));
		System.out.println("min3(6,2,2) = " + min3(6,2,2));
	}
}