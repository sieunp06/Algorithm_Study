import java.util.Scanner;
  
public class Main {
    private static int[] solution(int N, int[] numbers) {
		int[] answer = new int[N];
		
		for (int i = 0; i < N; i++) {
			answer[i] = 1;
			for (int j = 0; j < N; j++) {
				if (numbers[j] > numbers[i]) {
					answer[i]++;
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        
        int[] correct = new int[N];
        
        for (int i = 0; i < N; i++) {
            correct[i] = stdIn.nextInt();
        }
        
        for (int x: solution(N, correct)) {
            System.out.print(x + " ");
        }
    }
}