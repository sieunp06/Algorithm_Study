import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
            int[][] nums = new int[N][N];
            
            int dir = 0; 
            int x = 0; int y = 0;
            for (int i = 1; i <= N * N; i++) {
            	nums[x][y] = i;
                if (x + dx[dir] >= N || x + dx[dir] < 0 || y + dy[dir] >= N || y + dy[dir] < 0 || nums[x + dx[dir]][y + dy[dir]] != 0) {
                	dir = (dir + 1) % 4;
                }
                x += dx[dir];
                y += dy[dir];
            }
            
            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
            	for (int num : nums[i]) {
                	System.out.print(num + " ");
                }
                System.out.println();
            }
		}
	}
}