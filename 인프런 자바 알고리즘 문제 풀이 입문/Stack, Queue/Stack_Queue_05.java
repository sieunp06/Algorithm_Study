import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
  
public class Main {
  private static int solution (String input) {
		int answer = 0;
		
		Stack<Character> st = new Stack<>();
		
		for (int i = 0; i < input.length(); i++) {
			char in = input.charAt(i);
			if (in == ')') {
				st.pop();
				if (input.charAt(i - 1) != '(') 
					answer++;
				else 
					answer += st.size();
			} else {
				st.push(in);
			}
		}
		
		return answer;
	}
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        String input = bf.readLine();
        
        System.out.println(solution(input));
    }
}