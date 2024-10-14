import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
        StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
        
		for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
			int L = sc.nextInt();
            int U = sc.nextInt();
            int X = sc.nextInt();
            
            if (X < L) {
            	sb.append(L - X);
            } else if (X > U) {
            	sb.append(-1);
            } else {
            	sb.append(0);
            }
            sb.append("\n");
		}
        System.out.print(sb);
	}
}