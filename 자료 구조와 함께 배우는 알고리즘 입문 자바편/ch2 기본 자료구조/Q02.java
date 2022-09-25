/*
 * 연습문제 Q2
 * 아래처럼 배열 요소를 역순으로 정렬하는 과정을 하나하나 나타내는 프로그램을 작성하세요.
 * 
 * [출력 예시]
 * 5 10 73 2 -5 42
 * a[0]과(와) a[5]를 교환합니다.
 */

import java.util.Scanner;

public class Q02 {
    static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

    static void print(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

    static void reverse(int[] a) {
		print(a);
		for (int i = 0; i < a.length / 2; i++) {
			System.out.println("a[" + i + "]와 a[" + (a.length - i - 1) + "]를 교환합니다.");
			swap(a, i, a.length - i - 1);
			print(a);
		}
	}

    public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("요솟수는 ：");
		int num = stdIn.nextInt(); 

		int[] x = new int[num]; 

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}

		reverse(x); 

		System.out.println("역순 정렬을 마쳤습니다.");
	}
}
