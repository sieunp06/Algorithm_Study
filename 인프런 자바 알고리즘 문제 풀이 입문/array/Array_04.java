import java.util.*;
  
public class Main {
  static ArrayList<Integer> solution(int N) {	
		ArrayList<Integer> answer = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			if (i == 0 || i == 1)
				answer.add(1);
			else {
				answer.add(answer.get(i - 2) + answer.get(i - 1));
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args){
	    Scanner StdIn = new Scanner(System.in);
	    
	    int N = StdIn.nextInt();

	    for (int x : solution(N)) {
	    	System.out.print(x + " ");
	    }
	}
}