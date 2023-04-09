import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(bf.readLine());
        
        Stack<Integer> number = new Stack<>();
        
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(bf.readLine());
        	String input = st.nextToken();
        	
        	if (input.equals("push")) {
        		number.add(Integer.parseInt(st.nextToken()));
        	} else if (input.equals("pop")) {
        		if (number.isEmpty())
        			sb.append(-1).append('\n');
        		else {
        			sb.append(number.peek()).append('\n');
        		number.pop();
        		}
        	} else if (input.equals("size")) {
        		sb.append(number.size()).append('\n');
        	} else if (input.equals("empty")) {
        		if (number.isEmpty())
        			sb.append(1).append('\n');
        		else sb.append(0).append('\n');
        	} else if (input.equals("top")) {
        		if (number.isEmpty())
        			sb.append(-1).append('\n');
        		else 
        			sb.append(number.peek()).append('\n');
        	}
        }
        
        System.out.print(sb);
	}
}