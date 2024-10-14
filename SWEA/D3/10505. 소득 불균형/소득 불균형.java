import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
	
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
            int[] nums = new int[N];
            
            int total = 0;
            for (int i = 0; i < N; i++) {
                int num = sc.nextInt();
            	nums[i] = num;
                total += num;
            }
            int avg = total / N;
            
            int answer = 0;
            for (int num : nums) {
            	if (num <= avg) {
                	answer++;
                }
            }
            System.out.println("#" + test_case + " " + answer);
		}
	}
}