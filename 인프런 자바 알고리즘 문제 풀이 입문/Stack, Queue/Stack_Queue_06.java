import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
  
public class Main {
  private static int solution (int N, int K) {
		int answer = 0;
		
		Queue<Integer> prince = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) 
			prince.offer(i);
		
		int turn = 1;
		int num;
		
		while (prince.size() > 1) {
			if (turn == K) {
				prince.remove();
				turn = 1;
			}
			else {
				num = prince.poll();
				prince.offer(num);
				turn ++;
			}
		}
		answer = prince.poll();
		
		return answer;
	}
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        System.out.println(solution(N, K));
    }
}