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
        
        int N = Integer.parseInt(bf.readLine());
        
        Deque<Integer> deq = new ArrayDeque<>();
        
        while (N --> 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String command = st.nextToken();
            
            switch (command) {
                case "push_front":
                    deq.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deq.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (deq.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(deq.pollFirst()).append('\n');
                    break;
                case "pop_back":
                    if (deq.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(deq.pollLast()).append('\n');
                    break;
                case "size":
                    sb.append(deq.size()).append('\n');
                    break;
                case "empty":
                    if (deq.isEmpty())
                        sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "front":
                    if (deq.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(deq.peekFirst()).append('\n');
                    break;
                case "back":
                    if (deq.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(deq.peekLast()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}