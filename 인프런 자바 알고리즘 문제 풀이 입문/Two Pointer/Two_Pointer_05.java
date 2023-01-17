import java.util.Scanner;
  
public class Main {
  private static int solution(int N, int k, int[] numbers) {
		int count = 0;
		int sum = 0;
		int lt = 0;
		
		for (int rt = 0; rt < N; rt++) {
			sum += numbers[rt];
			if (sum == k) {
				count++;
			}
			while (sum >= k) {
				sum -= numbers[lt++];
				if (sum == k) count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        int k = stdIn.nextInt();
        
        int[] numbers = new int[N];
        
        for (int i = 0; i < N; i++) {
        	numbers[i] = stdIn.nextInt();
        }
        
        System.out.println(solution(N, k, numbers));
    }
}