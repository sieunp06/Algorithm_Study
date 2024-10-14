import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
	
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
            String text1 = sc.next();
            String text2 = sc.next();
            
            int answer = 0;
            for (int i = 0; i < N; i++) {
            	if (text1.charAt(i) == text2.charAt(i)) {
                	answer++;
                }
            }
            System.out.println("#" + test_case + " " + answer);
		}
	}
}