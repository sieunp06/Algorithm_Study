/*
 * 연습문제 Q17
 * 오른쪽과 같이 아래를 향한 n단의 숫자 피라미드를 출력하는 메서드를 작성하세요.
 * static void npira(int n)
 */

import java.util.Scanner;

import javax.print.attribute.Size2DSyntax;

public class Q17 {
    static void npira(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(' ');
            }
            for (int j = 1; j <= (i - 1) * 2 + 1; j++) {
            	System.out.print(i);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("단 수: ");
        int count = stdIn.nextInt();

        npira(count);
    }
}
