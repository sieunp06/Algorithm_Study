import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
            int fee = 0;
            int[] nums = new int[5];
            for (int i = 0; i < 5; i++) {
            	nums[i] = sc.nextInt();
            }
            int P = nums[0]; int Q = nums[1];
            int R = nums[2]; int S = nums[3];
            int W = nums[4];
            
            int A = calculateA(W, P);
            int B = calculateB(Q, W, R, S);
            
            if (A > B) {
            	fee = B;
            } else {
                fee = A;
            }
            
            System.out.println("#" + test_case + " "  + fee);
		}
	}
    
    private static int calculateA(int W, int P) {
    	return W * P;
    }
    
    private static int calculateB(int Q, int W, int R, int S) {
        if (W > R) {
        	return Q + (W - R) * S;
        }
    	return Q;
    }
}