import java.util.Scanner;
import java.io.FileInputStream;
import java.util.List;
import java.util.ArrayList;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
	
		for (int test_case = 1; test_case <= T; test_case++) {
			int total = sc.nextInt();
            int submit = sc.nextInt();
            boolean[] submitStudents = new boolean[total];
            
            for (int i = 0; i < submit; i++) {
            	submitStudents[sc.nextInt() - 1] = true;
            }
            
            sb.append("#").append(test_case).append(" ");
            for (int i = 0; i < total; i++) {
            	if (!submitStudents[i]) {
                	sb.append(i + 1).append(" ");
                }
            }
            sb.append("\n");
		}
        System.out.print(sb);
	}
}