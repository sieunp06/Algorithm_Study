import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int firstHour = sc.nextInt();
            int firstMin = sc.nextInt();
            
            int secondHour = sc.nextInt();
            int secondMin = sc.nextInt();
            
            int answerHour = firstHour + secondHour;
            int answerMin = firstMin + secondMin;
            
            while (answerMin >= 60) {
            	answerMin -= 60;
                answerHour++;
            }
            
            while (answerHour > 12) {
            	answerHour -= 12;
            }
            System.out.println("#" + test_case + " " + answerHour + " " + answerMin);
		}
	}
}