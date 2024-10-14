import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
            int hour = sc.nextInt() + sc.nextInt();
            while (hour >= 24) {
            	hour -= 24;
            }
            sb.append("#").append(test_case).append(" ").append(hour).append("\n");
		}
        System.out.println(sb);
	}
}