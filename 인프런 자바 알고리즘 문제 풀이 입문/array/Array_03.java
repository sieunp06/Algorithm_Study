import java.util.*;
  
public class Main {
  static ArrayList<Character> solution(int N, int[] A, int[] B) {	
		ArrayList<Character> answer = new ArrayList<>();
		char[][] RSP = {{'D', 'A', 'B'},
						{'B', 'D', 'A'},
						{'A', 'B', 'D'}};
		
		for (int i = 0; i < N; i++) {
			answer.add(RSP[B[i] - 1][A[i] - 1]);
		}
		
		return answer;
	}
	
	public static void main(String[] args){
	    Scanner StdIn = new Scanner(System.in);
	    
	    int N = StdIn.nextInt();
	    int[] A = new int[N];
	    int[] B = new int[N];
	    for (int i = 0; i < N; i++) {
	    	A[i] = StdIn.nextInt();
	    }
	    for (int i = 0; i < N; i++) {
	    	B[i] = StdIn.nextInt();
	    }

	    for (char x : solution(N, A, B)) {
	    	System.out.println(x);
	    }
	}
}