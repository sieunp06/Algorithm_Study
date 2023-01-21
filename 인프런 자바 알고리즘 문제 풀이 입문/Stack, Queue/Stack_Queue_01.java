import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {		
	private static String solution (String input) {

		Stack<Character> st = new Stack<>();
		
		for (char x: input.toCharArray()) {
			if (x == '(')
				st.push(x);
			else {
				if (st.isEmpty()) return "NO";
				else {
					st.pop();
				}
			}
		}

		if (!st.isEmpty()) return "NO";
		
		return "YES";
	}
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        String input = bf.readLine();
        
        System.out.println(solution(input));
    }
}
