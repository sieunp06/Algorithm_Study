import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
            	nums[i] = sc.nextInt();
            }
            
            long total = 0;
            long max = Long.MIN_VALUE;
            for (int i = N - 1; i >= 0; i--) {
                int num = nums[i];
            	if (num >= max) {
                	max = num;
                    continue;
                }
                total += max - num;
            }
            System.out.println("#" + test_case + " " + total);
		}
	}
}