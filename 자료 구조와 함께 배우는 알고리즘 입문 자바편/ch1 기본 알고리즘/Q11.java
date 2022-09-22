/*
 * 연습문제 Q11
 * 양의 정수를 입력하고 자릿수를 출력하는 프로그램을 작성하세요.
 * 예를 들어 135를 입력하면 '그 수를 3자리입니다.' 라고 출력하고,
 * 1314를 입력하면, '그 수는 4자리입니다.' 라고 출력하면 됩니다.
 */

import java.util.Scanner;

public class Q11 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int num;
        int count = 0;

        do {
			System.out.print("정수값：");
			num = stdIn.nextInt();
		} while (num <= 0);

        while (num > 0) {
            num /= 10;
            count ++;
        }

        System.out.println("그 수는 " + count + "자리입니다.");
    }
}
