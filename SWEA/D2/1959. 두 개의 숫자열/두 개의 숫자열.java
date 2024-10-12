
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
            int M = sc.nextInt();
            int[] numsN = new int[N];
            int[] numsM = new int[M];
            
            for (int i = 0; i < N; i++) {
            	numsN[i] = sc.nextInt();
            }
            
            for (int i = 0; i < M; i++) {
            	numsM[i] = sc.nextInt();
            }
            
            int answer = Integer.MIN_VALUE;
            if (N < M) {
            	for (int i = 0; i < M - N + 1; i++) {
                    int total = 0;
                	for (int j = 0; j < N; j++) {
                    	total += numsN[j] * numsM[i + j];
                    }
                    answer = Math.max(answer, total);
                }
            } else if (N > M) {
            	for (int i = 0; i < N - M + 1; i++) {
                    int total = 0;
                	for (int j = 0; j < M; j++) {
                    	total += numsN[i + j] * numsM[j];
                    }
                    answer = Math.max(answer, total);
                }
            } else {
                int total = 0;
            	for (int i = 0; i < N; i++) {
                	total += numsN[i] * numsM[i];
                }
                answer = Math.max(answer, total);
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}