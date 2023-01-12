import java.util.Scanner;
  
public class Main {
  private static int solution(int N, int[] numbers) {
		int score = 0;
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			if (numbers[i] == 1) {
				count++;
				score += count;
			} else {
				count = 0;
			}
		}
		return score;
	}
	
	public static void main(String[] args) {
      Scanner stdIn = new Scanner(System.in);
      
      int N = stdIn.nextInt();
      
      int[] correct = new int[N];
      
      for (int i = 0; i < N; i++) {
      	correct[i] = stdIn.nextInt();
      }
      
      System.out.println(solution(N, correct));
  }
}