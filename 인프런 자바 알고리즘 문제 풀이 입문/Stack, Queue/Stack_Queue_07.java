import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
  
public class Main {
  private static String solution(String nece, String input) {
		String answer = "YES";
		
		Queue<Character> nece_st = new LinkedList<>();
		Queue<Character> curriculum = new LinkedList<>();
		
		for (int i = 0; i < nece.length(); i++) 
			nece_st.offer(nece.charAt(i)); 
		
		for (int i = 0; i < input.length(); i++) 
			curriculum.offer(input.charAt(i));
		
		while (!curriculum.isEmpty()) {
			if (curriculum.peek() == nece_st.peek()) {
				nece_st.remove();
				curriculum.remove();
			} else {
				curriculum.remove();
			}
		}
		
		if (!nece_st.isEmpty()) return "NO";
		
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        String nece = bf.readLine();
        String input = bf.readLine();
        
        System.out.println(solution(nece, input));
    }
}