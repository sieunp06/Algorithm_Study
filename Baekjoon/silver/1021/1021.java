import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        LinkedList<Integer> dq = new LinkedList<>();
        int[] target = new int[M];
        
        for (int i = 1; i <= N; i++)
            dq.offer(i);
        
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++)
        	target[i] = Integer.parseInt(st.nextToken());
        
        int turn = 0;
        int count = 0;
        
        while (turn < M) {          
            // A 연산
            if (target[turn] == dq.peekFirst()) {
                turn++;
                dq.poll();
                continue;
            }
            
            int ind = dq.indexOf(target[turn]);
            int half = dq.size() / 2;
            
            // B 연산
            if (ind <= half) {
            	count++;
            	dq.offerLast(dq.poll());
            } else {
            	count++;
            	dq.offerFirst(dq.pollLast());
            }
        }
        System.out.println(count);
    }
}