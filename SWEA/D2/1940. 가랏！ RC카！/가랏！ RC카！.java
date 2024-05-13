import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int answer = 0;
			int N = sc.nextInt();
            int speed = 0;
            for (int command_case = 1; command_case <= N; command_case++) {
            	int command = sc.nextInt();
                
                if (command == 1) {	// 가속
                	speed += sc.nextInt();
                }
                if (command == 2) {	// 감속
                	speed -= sc.nextInt();
                    if (speed < 0) {
                    	speed = 0;
                    }
                }
                answer += speed;
            }
            sb.append(answer).append("\n");
		}
        System.out.println(sb);
	}
}