import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;
  
public class Main {
  private static int solution (int N, int M, int[][] board, int[] moves) {
		int answer = 0;
		
		Stack<Integer> vending = new Stack<>();
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				int num = board[j][moves[i] - 1];
				
				if (num > 0) {
					if (vending.isEmpty()) vending.push(num);
					else if (vending.peek() == num) {
						vending.pop();
						answer ++;
					}
					else {
						vending.push(num);
					}
					board[j][moves[i] - 1] = 0;
					
					break;
				}
			}
		}
		
		return answer * 2;
	}
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bf.readLine());
        int[][] board = new int[N][N];
        
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(bf.readLine());
        	for (int j = 0; j < N; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int M = Integer.parseInt(bf.readLine());
        int[] moves = new int[M];
        
        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        
        for (int i = 0; i < M; i++) 
        	moves[i] = Integer.parseInt(st1.nextToken());
        			
        System.out.println(solution(N, M, board, moves));
    }
}