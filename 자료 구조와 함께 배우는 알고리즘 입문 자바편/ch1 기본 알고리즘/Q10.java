/*
 * 연습문제 Q10
 * 아래와 같이 두 변수 a, b에 정수를 입력하고 b - a를 출력하는 프로그램을 작성하세요.
 * [출력 예시]
 * a의 값: 6
 * b의 값: 6
 * a보다 큰 값을 입력하세요!
 * b의 값: 8
 * b - a는 2입니다.
 */

import java.util.Scanner;

public class Q10 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("a의 값: ");
        int a = stdIn.nextInt();
        int b;

        while(true) {
            System.out.print("b의 값: ");
            b = stdIn.nextInt();

            if (a <= b)
                break;
            System.out.println("a보다 큰 값을 입력하세요!");
        }
        
        System.out.println("b - a는 " + (b - a) + "입니다.");
        
    }
}
