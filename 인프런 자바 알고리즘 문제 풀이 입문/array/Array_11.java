import java.util.Scanner;
  
public class Main {
  private static int solution(int N, int[][] number) {
		int answer = 0;
		int max = Integer.MIN_VALUE;
		
		for (int i = 1; i <= N; i++) {
			int count = 0;
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= 5; k++) {
					if (number[i][k] == number[j][k]) {
						count++;
						break;
					}
				}
			}
			if (count > max) {
				max = count;
				answer = i;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        
        int[][] number = new int[N + 1][6];
        
        for (int i = 1; i <= N; i++) {
        	for (int j = 1; j <= 5; j++) {
        		number[i][j] = stdIn.nextInt();
        	}
        }
        
        System.out.println(solution(N, number));
    }
}