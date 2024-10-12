import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++){
			int answer = 0;
            
            int N = sc.nextInt(); int K = sc.nextInt();
            int[][] board = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                int temp = 0;
            	for (int j = 0; j < N; j++) {
                	board[i][j] = sc.nextInt();
                    if (board[i][j] == 1) {
                    	temp++;
                    } else {
                    	if (temp == K) {
                        	answer++;
                        }
                        temp = 0;
                    }
                }
                if (temp == K) {
                    answer++;
                }
            }
            
            for (int i = 0; i < N; i++) {
                int temp = 0;
            	for (int j = 0; j < N; j++) {
                	if (board[j][i] == 1) {
                    	temp++;
                    } else {
                    	if (temp == K) {
                        	answer++;
                        }
                        temp = 0;
                    }
                }
                if (temp == K) {
                    answer++;
                }
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}