import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int answer = 0;
	static int[] dis = {1, -1, 5};
	static int[] ch;
	static Queue<Integer> Q = new LinkedList<>();
	
	public static int solution(int S, int E) {
		ch = new int[10001];
		ch[S] = 1;
		
		Q.offer(S);
		
		int L = 0;
		
		while (!Q.isEmpty()) {
			int len = Q.size();
			
			for (int i = 0; i < len; i++) {
				int x = Q.poll();
				
				if (x == E) return L;
				
				for (int j = 0; j < 3; j++) {
					int nx = x + dis[j];
					
					if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
						ch[nx] = 1;
						Q.offer(nx);
					}
				}
			}
			L++;
		}
		return 0;
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(bf.readLine());
    	
    	int S = Integer.parseInt(st.nextToken());
    	int E = Integer.parseInt(st.nextToken());
    	
    	System.out.println(solution(S, E));
    }
}