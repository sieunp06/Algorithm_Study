import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T=sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            
			int answer = -1;
            if (num1 < 10 && num2 < 10) {
            	answer = num1 * num2;
            }
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
        System.out.print(sb);
	}
}