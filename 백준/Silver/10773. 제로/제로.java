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
        	String input = bf.readLine();
        	
        	if (input.equals("0"))
        		number.pop();
        	else 
        		number.add(Integer.parseInt(input));
        }
        
        int total = 0;
        
        for (int x: number)
        	total += x;
        
        sb.append(total);
        System.out.print(sb);
	}
}