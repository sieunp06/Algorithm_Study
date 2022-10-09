/*
 * 연습문제 Q05
 * 배열 b의 모든 요소를 배열 a에 역순으로 복사하는 메서드 rcopy를 작성하세요.
 * static void rcopy(int[] a, int[] b)
 */

import java.util.Scanner;

public class Q05 {
    static void rcopy(int[] a, int[] b) {   
        int num = a.length <= b.length ? a.length : b.length;
        for (int i = 0; i < num; i++) {
            a[i] = b[b.length - 1 - i];
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("배열 a의 요솟수: ");
        int numA = stdIn.nextInt();

        int[] a = new int[numA];

        for (int i = 0; i < numA; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = stdIn.nextInt();
        }

        System.out.print("배열 b의 요솟수: ");
        int numB = stdIn.nextInt();

        int[] b = new int[numB];

        for (int i = 0; i < numB; i++) {
            System.out.print("b[" + i + "] = ");
            b[i] = stdIn.nextInt();
        }

        rcopy(a, b);

        System.out.println("역순으로 복사 완료!");

        for (int i = 0; i < numA; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }
}
