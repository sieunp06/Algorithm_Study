import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
  
public class Main {
  private static ArrayList<Integer> solution(int[] num1, int[] num2) {
		ArrayList<Integer> answer = new ArrayList<>();
		
		Arrays.sort(num1);
		Arrays.sort(num2);
		
		int one = 0;
		int two = 0;
		
		while (one < num1.length && two < num2.length) {
			if (num1[one] == num2[two]) {
				answer.add(num1[one++]);
				two++;
			} else if (num1[one] < num2[two]) {
				one++;
			} else {
				two++;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        int[] num1 = new int[N];
        
        for (int i = 0; i < N; i++) 
        	num1[i] = stdIn.nextInt();
        
        int M = stdIn.nextInt();
        int[] num2 = new int[M];
        
        for (int i = 0; i < M; i++) 
        	num2[i] = stdIn.nextInt();
        
        ArrayList<Integer> answer = new ArrayList<>();
        answer = solution(num1, num2);
        
        for (int i = 0; i < answer.size(); i++) {
        	System.out.print(answer.get(i) + " ");
        }
    }
}