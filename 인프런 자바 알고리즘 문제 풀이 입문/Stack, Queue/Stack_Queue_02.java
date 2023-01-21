import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
  
public class Main {
  private static String solution (String input) {
		String answer = "";
		
		Stack<Character> st = new Stack<>();
		
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != ')')
				st.push(input.charAt(i));
			else {
				while (st.peek() != '(') {
					st.pop();
				}
				st.pop();
			}
		}
		
		for (char x : st) 
			answer += x;
		
		return answer;
	}
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        String input = bf.readLine();
        
        System.out.println(solution(input));
    }
}