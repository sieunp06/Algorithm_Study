import java.util.Scanner;
import java.util.Arrays;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		int[] nums = new int[T];
        
        for (int i = 0; i < nums.length; i++) {
        	nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        System.out.println(nums[nums.length / 2]);
	}
}