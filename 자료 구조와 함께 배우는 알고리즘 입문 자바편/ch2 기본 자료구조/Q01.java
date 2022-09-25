/*
 * 연습문제 Q01
 * 키뿐만 아니라 사람 수도 난수로 생성하도록 실습 2-5를 수정하여 프로그램을 작성하세요.
 */

import java.util.Random;
import java.util.Scanner;

public class Q01 {
    static int maxOf(int[] a) {
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) 
                max = a[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner stdIn = new Scanner(System.in);

        System.out.println("키의 최댓값을 구합니다.");
        
        int person = 1 + rand.nextInt(20);
        int[] height = new int[person];

        System.out.println("키 값은 아래와 같습니다.");
        for (int i = 0; i < person; i++) {
            height[i] = 100 + rand.nextInt(90);
            System.out.println("height[" + i + "] : " + height[i]);
        }

        System.out.println("사람수는 " + person + "입니다.");
        System.out.println("키 최댓값은 " + maxOf(height) + "입니다.");
    }
}
