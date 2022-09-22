/*
 * 연습문제 Q9
 * 정수 a, b를 포함하여 그 사이의 모든 정수의 합을 구하여 반환하는 아래 메서드를 작성하세요.
 * static int sumof(int a, int b)
 * a와 b의 대소관계에 상관없이 합을 구하세요.
 * (a가 3, b가 5면 12, a가 6, b가 4면 15)
 */

import java.util.Scanner;

public class Sumof {
    static int sumof(int a, int b) {
        int min;
		int max;

		if (a < b) {
			min = a;
			max = b;
		} else {
			min = b;
			max = a;
		}

		int sum = 0;
		for (int i = min; i <= max; i++)
			sum += i;
		return (sum);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

		System.out.println("a와 b를 포함하여 그 사이의 모든 정수의 합을 구합니다.");
		System.out.print("a의 값：");
		int a = stdIn.nextInt();
		System.out.print("b의 값：");
		int b = stdIn.nextInt();

		System.out.println("정수 a, b 사이의 모든 정수의 합은 " + sumof(a, b) + "입니다.");
    } 
}
