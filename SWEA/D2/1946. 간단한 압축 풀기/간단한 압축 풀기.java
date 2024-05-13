import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder answer;
        StringBuilder line;
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
            answer = new StringBuilder();
            line = new StringBuilder();
            System.out.println("#" + test_case);
			int N = sc.nextInt();
            for (int i = 0; i < N; i++) {
            	String alpha = sc.next();
                int count = sc.nextInt();
                
                for (int j = 0; j < count; j++) {
                    if (line.length() == 10) {
                    	answer.append(line).append("\n");
                        line = new StringBuilder();
                    }
                	line.append(alpha);
                }
            }
            if (!line.toString().equals("")) {
                answer.append(line);
            }
         	System.out.println(answer);
		}
	}
}