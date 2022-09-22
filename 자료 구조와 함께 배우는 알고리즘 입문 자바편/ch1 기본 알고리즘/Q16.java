/*
 * 연습문제 Q16
 * n단의 피라미드를 출력하는 메서드를 작성하세요.
 * static void spira(int n)
 */

import java.util.Scanner;

public class Q16 {
    static public void spira(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(' ');
            }
            for (int j = 1; j <= (i - 1) * 2 + 1; j++) {
            	System.out.print('*');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("단 수: ");
        int n = stdIn.nextInt();

        spira(n);
    }
}
