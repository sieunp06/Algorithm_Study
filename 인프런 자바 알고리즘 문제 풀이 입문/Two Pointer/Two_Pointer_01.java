import java.util.Scanner;
  
public class Main {
  private static int[] solution(int[] num1, int[] num2) {
		int one = 0;
		int two = 0;
		
		int total_ind = num1.length + num2.length;
		
		int[] answer = new int[total_ind];
		
		while (one + two <= total_ind) {
			if (one == num1.length) {
				for (int i = two; i < num2.length; i++) {
					answer[one + two] = num2[two];
					two++;
				}
				break;
			}
			if (two == num2.length) {
				for (int i = one; i < num1.length; i++) {
					answer[one + two] = num1[one];
					one++;
				}
				break;
			}
			if (num1[one] < num2[two]) {
				answer[one + two] = num1[one];
				one++;
			} else {
				answer[one + two] = num2[two];
				two++;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        int[] num1 = new int[N];
        
        for (int i = 0; i < N; i++) {
        	num1[i] = stdIn.nextInt();
        }
        
        int M = stdIn.nextInt();
        int[] num2 = new int[M];
        
        for (int i = 0; i < M; i++) {
        	num2[i] = stdIn.nextInt();
        }
        
        int[] answer = new int[N + M];
        answer = solution(num1, num2);
        
        for (int i = 0; i < N + M; i++) {
        	System.out.print(answer[i] + " ");
        }
    }
}