import java.util.Scanner;
import java.util.HashMap;
  
public class Main {
  private static char solution(int N, String text) {
		char answer = 0;
		int max = Integer.MIN_VALUE;
		
		HashMap<Character, Integer> vote = new HashMap<>();
		
		for (char x : text.toCharArray()) {
			if (!vote.containsKey(x)) 
				vote.put(x, 1);
			else 
				vote.put(x, vote.get(x) + 1);	
		}
		
		for(char i : vote.keySet()){ 
		    if (max < vote.get(i)) {
		    	max = vote.get(i);
		    	answer = i;
		    }
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        String text = stdIn.next();
        
        System.out.println(solution(N, text));
    }
}