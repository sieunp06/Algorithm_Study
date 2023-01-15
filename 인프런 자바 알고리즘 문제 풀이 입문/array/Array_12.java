import java.util.Scanner;
  
public class Main {
  private static int solution(int N, int M, int[][] number) {
		int answer = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int cnt = 0;
				for (int k = 0; k < M; k++) {
					int pi = 0, pj = 0;
					for (int s = 0; s < N; s++) {
						if (number[k][s] == i) pi = s;
						if (number[k][s] == j) pj = s;
					}
					if (pi < pj) cnt++;
				}
				if (cnt == M)
					answer++;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        int M = stdIn.nextInt();
        
        int[][] number = new int[M][N];
        
        for (int i = 0; i < M; i++) {
        	for (int j = 0; j < N; j++) {
        		number[i][j] = stdIn.nextInt();
        	}
        }
        
        System.out.println(solution(N, M, number));
    }
}