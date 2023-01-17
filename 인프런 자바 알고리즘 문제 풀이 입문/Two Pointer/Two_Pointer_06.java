import java.util.Scanner;
  
public class Main {
  private static int solution(int N) {
		int M = N/2 + 1;
		int[] numbers = new int[M];
		
		int count = 0;
		int sum = 0;
		int lt = 0;
		
		for (int i = 0; i < M; i++)
			numbers[i] = i + 1;
		
		for (int rt = 0; rt < M; rt++ ) {
			sum += numbers[rt];
			if (sum == N) count++;
			while(sum >= N) {
				sum -= numbers[lt++];
				if (sum == N) count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        
        System.out.println(solution(N));
    }
}