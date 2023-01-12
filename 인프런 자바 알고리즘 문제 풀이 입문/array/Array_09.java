import java.util.Scanner;
  
public class Main {
  private static int solution(int N, int[][] numbers) {
		int answer = Integer.MIN_VALUE;
		
		int sum1, sum2;
		
		for (int i = 0; i < N; i++) {
			sum1 = sum2 = 0;
			for (int j = 0; j < N; j++) {
				sum1 += numbers[i][j];
				sum2 += numbers[j][i];
			}
			answer = Math.max(answer, sum1);
			answer = Math.max(answer, sum2);
		}
		
		sum1 = sum2 = 0;
		for (int i = 0; i < N; i++) {
			sum1 += numbers[i][i];
			sum2 += numbers[i][N - i - 1];
		}
		answer = Math.max(answer, sum1);
		answer = Math.max(answer, sum2);
		
		return answer;
	}
	
	public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    
    int N = stdIn.nextInt();
    
    int[][] answer = new int[N][N];
    
    for (int i = 0; i < N; i++) {
    	for (int j = 0; j < N; j++) {
    		answer[i][j] = stdIn.nextInt();
    	}
    }
    
    System.out.println(solution(N, answer));
  }
}