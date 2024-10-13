import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");

            int[] nums = new int[10];
            for (int i = 0; i < 10; i++) {
            	nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            
            double total = 0;
            for (int i = 1; i < 9; i++) {
            	total += nums[i];
            }
            sb.append(Math.round(total / 8)).append("\n");
        }
        
        System.out.println(sb);
	}
}