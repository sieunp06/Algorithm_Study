/*
 * 연습문제 Q07
 * 아래쪽처럼 기수 변환 과정을 자세히 나타내는 프로그램을 작성하세요.
 */

import java.util.Scanner;

public class Q07 {
    static int cardConvEx(int x, int r, char[] d) {
		int n = ((Integer) x).toString().length();
		int digits = 0; 
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		System.out.printf(String.format("%%2d | %%%dd\n", n), r, x);
		do {
			System.out.printf("   +");
			for (int i = 0; i < n + 2; i++)
				System.out.print('-');
			System.out.println();

			if (x / r != 0)
				System.out.printf(String.format("%%2d | %%%dd    … %%d\n", n), r, x / r, x % r);
			else
				System.out.printf(String.format("     %%%dd    … %%d\n", n), x / r, x % r);
			d[digits++] = dchar.charAt(x % r); 
			x /= r;
		} while (x != 0);

		for (int i = 0; i < digits / 2; i++) { 
			char temp = d[i]; 
			d[i] = d[digits - i - 1];
			d[digits - i - 1] = temp;
		}
		return digits;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int no; 
		int cd; 
		int dno; 
		int retry; 
		char[] cno = new char[32]; 

		System.out.println("10진수를 기수변환합니다.");
		do {
			do {
				System.out.print("변환하는 음이 아닌 정수：");
				no = stdIn.nextInt();
			} while (no < 0);

			do {
				System.out.print("어떤 진수로 변환할까요? (2~36)：");
				cd = stdIn.nextInt();
			} while (cd < 2 || cd > 36);

			dno = cardConvEx(no, cd, cno); 

			System.out.print(cd + "진수로는 ");
			for (int i = 0; i < dno; i++)
				System.out.print(cno[i]);
			System.out.println("입니다.");

			System.out.print("한번 더 할까요? (1.예/0.아니오)：");
			retry = stdIn.nextInt();
		} while (retry == 1);
	}
}
