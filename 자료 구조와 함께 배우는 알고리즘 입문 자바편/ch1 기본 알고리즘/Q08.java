/*
 * 연습문제 Q8
 * 1부터 10까지의 합은 (1 + 10) * 5와 같은 방법으로 구할 수 있습니다.
 * 가우스의 덧셈이라는 방법을 이용하여 1부터 n까지의 정수의 합을 구하는 프로그램을 작성하세요.
 */

import java.util.Scanner;

public class Q08 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("가우스의 덧셈으로 1부터 n까지의 합을 구합니다.");
        System.out.print("n의 값: ");
        int n = stdIn.nextInt();

        int sum = (1 + n) * (n / 2) + (n % 2 == 1 ? (n + 1) / 2 : 0);

        System.out.println("sum : " + sum);
    }
}
