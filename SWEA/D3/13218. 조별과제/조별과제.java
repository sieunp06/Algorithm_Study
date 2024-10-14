import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
            int count = sc.nextInt() / 3;
            sb.append("#").append(test_case).append(" ").append(count).append("\n");
		}
        System.out.print(sb);
	}
}