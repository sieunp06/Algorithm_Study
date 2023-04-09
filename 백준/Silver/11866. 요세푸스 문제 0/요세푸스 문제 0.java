import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        		
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 1; i <= N; i++)
        	q.offer(i);
        
        while (q.size() > 0) {
            for (int i = 0; i < K - 1; i++)
            	q.offer(q.poll());
            if (q.size() != 1)
            	sb.append(q.poll()).append(", ");
            else sb.append(q.poll()).append('>');
        }
        
        System.out.println(sb);
    }
}