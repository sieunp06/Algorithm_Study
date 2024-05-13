import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
            int num = sc.nextInt();
            int total = 0;
            for (int i = 1; i <= num; i++) {
            	if (i % 2 == 0) {
                	total -= i;
                } else {
                	total += i;
                }
            }
            
            System.out.println("#" + test_case + " " + total);
		}
	}
}