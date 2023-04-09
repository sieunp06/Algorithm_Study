import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bf.readLine());
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 1; i <= N; i++) 
            q.offer(i);
        
        while (q.size() > 1) {
            q.poll();
            q.offer(q.poll());
        }
        System.out.println(q.peek());
    }
}