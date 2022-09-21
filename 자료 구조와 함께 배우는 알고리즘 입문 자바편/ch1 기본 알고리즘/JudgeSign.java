/*
 * 실습 1-3
 * 입력한 정수값의 부호(양수/음수/0)를 판단하여 출력하는 프로그램
 */

import java.util.Scanner;

public class JudgeSign {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요.");
        int n = stdIn.nextInt();

        if (n > 0) 
            System.out.println("이 수는 양수입니다.");
        else if (n < 0) 
            System.out.println("이 수는 음수입니다.");
        else
            System.out.println("이 수는 0입니다.");
    }
}
