import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
  
public class Main {
  private static int solution (String input) {
		int answer = 0;
		
		Stack<Integer> st = new Stack<>();
		
		for (int i = 0; i < input.length(); i++) {
			int b;
			int a;
			
			if (input.charAt(i) == '+') {
				b = st.peek();
				st.pop();
				a = st.peek();
				st.pop();
				st.push(a + b);
			}
			else if (input.charAt(i) == '-') {
				b = st.peek() ;
				st.pop();
				a = st.peek();
				st.pop();
				st.push(a - b);
			}
			else if (input.charAt(i) == '*') {
				b = st.peek();
				st.pop();
				a = st.peek();
				st.pop();
				st.push(a * b);
			}
			else if (input.charAt(i) == '/') {
				b = st.peek();
				st.pop();
				a = st.peek();
				st.pop();
				st.push(a / b);
			}
			else
				st.push((int)(input.charAt(i) - 48));
		}
		
		answer = st.peek();
		
		return answer;
	}
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        String input = bf.readLine();
        
        System.out.println(solution(input));
    }
}