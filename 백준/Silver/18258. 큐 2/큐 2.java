import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        int N = Integer.parseInt(bf.readLine());
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String input = st.nextToken();
            if (input.equals("push")) {
                dq.offer(Integer.parseInt(st.nextToken()));
            } else if (input.equals("pop")) {
                if (dq.isEmpty())
                    sb.append(-1).append('\n');
                else 
                    sb.append(dq.poll()).append('\n');
            } else if (input.equals("size"))
                sb.append(dq.size()).append('\n');
            else if (input.equals("empty")) {
                if (dq.isEmpty())
                    sb.append(1).append('\n');
                else sb.append(0).append('\n');
            } else if (input.equals("front")) {
                if (dq.isEmpty())
                    sb.append(-1).append('\n');
                else 
                    sb.append(dq.peek()).append('\n');
            } else if (input.equals("back")) {
                if (dq.isEmpty())
                    sb.append(-1).append('\n');
                else 
                    sb.append(dq.peekLast()).append('\n');
            }
        }
        System.out.println(sb);
    }
}