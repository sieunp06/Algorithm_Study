import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int idx = 1;
            boolean[] nums = new boolean[10];
            
            while (true) {
                String num = String.valueOf(idx * N);
                for (int i = 0; i < num.length(); i++) {
                	nums[num.charAt(i) - '0'] = true;
                }
                
                boolean flag = true;
            	for (int i = 0; i < 10; i++) {
                	if (!nums[i]) {
                        flag = false;
                    	break;
                    }
                }
                if (flag) break;
                idx++;
            }
            
            System.out.println("#" + test_case + " " + idx * N);
		}
	}
}