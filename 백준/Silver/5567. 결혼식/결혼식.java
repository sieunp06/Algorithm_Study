import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] relation;
	static int cnt;
	static boolean selected[];
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		relation = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			relation[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			relation[a].add(b);
			relation[b].add(a);
		}
		
		selected = new boolean[N+1];
		selected[1] = true;
		cnt = 0;
		BFS(1,0);
		System.out.println(cnt);

	}
	static void BFS(int start, int depth) {
		Queue<Integer> queue = new LinkedList<>(); 
		if(depth==2) return;
		int idx = 0;
		while(!relation[start].isEmpty()) {
			int friend = relation[start].remove(idx);
			if(selected[friend]) continue;
			selected[friend] = true;
			cnt++;
			queue.add(friend);
		}
		while(!queue.isEmpty()) {
			BFS(queue.poll(),depth+1);
		}
	}
	
}
//6
//5
//1 2
//1 3
//3 4
//2 3
//4 5
//6
//5
//2 3
//3 4
//4 5
//5 6
//2 5