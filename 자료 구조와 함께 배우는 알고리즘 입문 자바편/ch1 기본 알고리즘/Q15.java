/*
 * 연습문제 Q15
 * 직각 이등변 삼각형을 출력하는 부분을 아래와 같은 형식의 메서드로 작성하세요.
 * static void triangleLB(int n)
 * 또한 왼쪽 위, 오른쪽 위, 오른쪽 아래가 직각인 이등변 삼각형을 출력하는 메서드를 작성하세요.
 * static void triangleLU(int n)
 * static void triangleRU(int n)
 * static void triangleRB(int n)
 */

import java.util.Scanner;

public class Q15 {
    // 왼쪽 아래가 직각인 이등변삼각형
	static void triangleLB(int n) {
		for (int i = 1; i <= n; i++) { 				
			for (int j = 1; j <= i; j++) 			
				System.out.print('*');
			System.out.println(); 					
		}
	}

	// 왼쪽 위가 직각인 이등변삼각형
	static void triangleLU(int n) {
		for (int i = 1; i <= n; i++) { 				
			for (int j = 1; j <= n - i + 1; j++) 	
				System.out.print('*');
			System.out.println(); 					
		}
	}

	// 오른쪽 위가 직각인 이등변삼각형
	static void triangleRU(int n) {
		for (int i = 1; i <= n; i++) { 				
			for (int j = 1; j <= i - 1; j++) 		
				System.out.print(' ');
			for (int j = 1; j <= n - i + 1; j++) 	
				System.out.print('*');
			System.out.println();				
		}
	}

	// 오른쪽 아래가 직각인 이등변삼각형
	static void triangleRB(int n) {
		for (int i = 1; i <= n; i++) { 				
			for (int j = 1; j <= n - i; j++) 	
				System.out.print(' ');
			for (int j = 1; j <= i; j++) 			
				System.out.print('*');
			System.out.println(); 					
		}
	}

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("단 수: ");
        int count = stdIn.nextInt();

        System.out.println("--왼쪽 아래가 직각 이등변 삼각형--");
        triangleLB(count);
        
        System.out.println("--왼쪽 위가 직각 이등변 삼각형--");
        triangleLU(count);
        
        System.out.println("--오른쪽 아래가 직각 이등변 삼각형--");
        triangleRB(count);
        
        System.out.println("--오른쪽 위가 직각 이등변 삼각형--");
        triangleRU(count);

    }
}
