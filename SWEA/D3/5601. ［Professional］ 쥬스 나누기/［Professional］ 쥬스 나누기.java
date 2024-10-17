import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
	
		for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
			int n = sc.nextInt();
            
            for (int i = 0; i < n; i++) {
            	sb.append("1/").append(n).append(" ");
            }
            sb.append("\n");
		}
        System.out.print(sb);
	}
}