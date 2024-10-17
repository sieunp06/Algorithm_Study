import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        String[] weekday = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

		for (int test_case = 1; test_case <= T; test_case++) {
			String target = sc.next();
            int answer = -1;
            
            for (int i = 0; i < weekday.length; i++) {
            	if (target.equals(weekday[i])) {
                	answer = 6 - i;
                    break;
                }
            }
            if (answer == 0) {
            	answer = 7;
            }
            System.out.println("#" + test_case + " " + answer);
		}
	}
}