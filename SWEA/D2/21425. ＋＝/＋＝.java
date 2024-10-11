import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
            int count = 0;
			int A = sc.nextInt();
            int B = sc.nextInt();
            int N = sc.nextInt();
            
            while (A <= N && B <= N) {
                if (A < B) {
                	A += B;
                } else {
                	B += A;
                }
                count++;
            }
            System.out.println(count);
		}
	}
}