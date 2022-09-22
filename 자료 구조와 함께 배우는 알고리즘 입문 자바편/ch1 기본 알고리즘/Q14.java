/*
 * 연습문제 Q14
 * 입력한 수를 한 변으로 하는 정사각형을 * 기호로 출력하는 프로그램을 작성하세요.
 */

import java.util.Scanner;

public class Q14 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("단 수: ");
        int count = stdIn.nextInt();

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
