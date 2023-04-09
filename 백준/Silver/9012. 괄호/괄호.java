import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(bf.readLine());
        
        for (int i = 0; i < N; i++) {
        	Stack<Character> st = new Stack<>();
        	String input = bf.readLine();
        	boolean check = true;
        	
        	for (int j = 0; j < input.length(); j++) {
        		char te = input.charAt(j);
        		
        		if (te == '(')
        			st.add(te);
        		else {
        			if (st.isEmpty()) {
        				check = false;
        				break;
        			}
        			else st.pop();
        		}
        	}
        	if (!st.isEmpty()) check = false;
        	
        	
        	if (!check) sb.append("NO").append('\n');
        	else sb.append("YES").append('\n');
        }
        
        System.out.print(sb);
	}
}