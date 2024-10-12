import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
			int[][] board = new int[N][N];
            
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < N; j++) {
                	board[i][j] = sc.nextInt();
                }
            }
            
            int[][] rotated_90 = rotate(board);
            int[][] rotated_180 = rotate(rotated_90);
            int[][] rotated_270 = rotate(rotated_180);
            
            sb.append("#").append(test_case).append("\n");
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < N; j++) {
                	sb.append(rotated_90[i][j]);
                }
                sb.append(" ");
                for (int j = 0; j < N; j++) {
                	sb.append(rotated_180[i][j]);
                }
                sb.append(" ");
                for (int j = 0; j < N; j++) {
                	sb.append(rotated_270[i][j]);
                }
                sb.append("\n");
            }
		}
        System.out.print(sb);
	}
    
    private static int[][] rotate(int[][] board) {
    	int[][] result = new int[board.length][board.length];
        
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board.length; j++) {
            	result[j][board.length - i - 1] = board[i][j];
            }
        }
        
        return result;
    }
}