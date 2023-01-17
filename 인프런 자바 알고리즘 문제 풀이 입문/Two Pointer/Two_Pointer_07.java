import java.util.Scanner;
  
public class Main {
  private static int solution(int N, int k, int[] input) {
		int answer = 0;
		int count = 0;
		int lt = 0;
		
		for (int rt = 0; rt < N; rt++) {
			if (input[rt] == 0) count++;
			while (count > k) {
				if (input[lt] == 0) count--;
				lt++;
			}
			answer = Math.max(answer, rt - lt + 1);
		}
		return answer;
	}
	
	public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        int k = stdIn.nextInt();
        
        int[] input = new int[N];
        
        for (int i = 0; i < N; i++) 
        	input[i] = stdIn.nextInt();
        
        System.out.println(solution(N, k, input));
    }
}