import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(bf.readLine());
        
        while(T --> 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            LinkedList<int[]> q = new LinkedList<>();
            
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) 
                q.offer(new int[] {i, Integer.parseInt(st.nextToken())});
            
            int turn = 0;
            
            while (!q.isEmpty()) {
            	int[] first = q.poll();
            	boolean isMax = true;
            	
            	for (int k = 0; k < q.size(); k++) {
            		if (first[1] < q.get(k)[1]) {
            			q.offer(first);
            			for (int m = 0; m < k; m++)
            				q.offer(q.poll());
            			isMax = false;
                		break;
            		}
            	}
            	
            	if(!isMax) 
					continue;
            	
            	turn++;
            	if (first[0] == M) 
            		break;
            }
            sb.append(turn).append('\n');
        }
        System.out.println(sb);
    }
}