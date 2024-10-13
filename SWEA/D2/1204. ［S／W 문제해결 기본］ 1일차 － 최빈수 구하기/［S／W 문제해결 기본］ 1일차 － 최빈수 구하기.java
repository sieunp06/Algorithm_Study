import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(sc.nextInt()).append(" ");
            
            int[] score = new int[101];
            for (int i = 0; i < 1000; i++) {
            	score[sc.nextInt()]++;
            }	
            
            int max = Integer.MIN_VALUE; int idx = -1;
            for (int i = 1; i < score.length; i++) {
            	if (max <= score[i]) {
                	max = score[i];
                    idx = i;
                }
            }
      		
            sb.append(idx).append("\n");
		}
        System.out.print(sb);
	}
}