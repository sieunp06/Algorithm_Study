import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
        int[] numbers = {2, 3, 5, 7, 11};

		for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int num = sc.nextInt();
            
            for (int number: numbers) {
                int round = 0;
            	while (num % number == 0) {
                	num /= number;
                    round++;
                }
                sb.append(round).append(" ");
            }
            sb.append("\n");
		}
        System.out.println(sb);
	}
}