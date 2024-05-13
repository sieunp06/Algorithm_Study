import java.util.Scanner;
import java.util.Arrays;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder answer = new StringBuilder();
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
            int[] numbers = new int[N];
            for (int i = 0; i < N; i++) {
            	numbers[i] = sc.nextInt();
            }
            Arrays.sort(numbers);
            
            answer.append("#").append(test_case).append(" ");
            for (int num: numbers) {
            	answer.append(num).append(" ");
            }
            answer.append("\n");
		}
        System.out.println(answer);
	}
}