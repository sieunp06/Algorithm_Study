import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String input;
        
        while (true) {
            boolean check = true;
            Stack<Character> st = new Stack<>();
            
            input = bf.readLine();
            if (input.equals("."))
                break;
            
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(' || input.charAt(i) == '[') {
                    st.push(input.charAt(i));
                } 
                if (input.charAt(i) == ')') {
                    if (st.isEmpty()) {
                        check = false;
                        break;
                    }
                    else if (st.peek() == '(')
                        st.pop();
                    else {
                        check = false;
                        break;
                    }
                }
                if (input.charAt(i) == ']') {
                    if (st.isEmpty()) {
                        check = false;
                        break;
                    }
                    else if (st.peek() == '[')
                        st.pop();
                    else {
                        check = false;
                        break;
                    }
                }
            }
            
            if (!st.isEmpty())
            	check = false;
            
            if (!check)
                sb.append("no").append('\n');
            else 
                sb.append("yes").append('\n');
        }
        System.out.println(sb);
    }
}