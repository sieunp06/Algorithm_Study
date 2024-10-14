import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
			int N = sc.nextInt();
            
            int up = 0; int down = 0;
            int now = sc.nextInt();
            for (int i = 1; i < N; i++) {
            	int num = sc.nextInt();
                if (now < num) {	// up
                	if (up < num - now) {
                    	up = num - now;
                    }
                } 
                if (now > num) {	// down
                	if (down < now - num) {
                    	down = now - num;
                    }
                }
                now = num;
            }
            sb.append(up).append(" ").append(down).append("\n");
		}
        System.out.print(sb);
	}
}