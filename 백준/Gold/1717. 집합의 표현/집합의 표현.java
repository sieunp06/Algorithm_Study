import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;
    
    private static int n, m;
    private static int[] parent, rank;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
    	stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    	
    	n = Integer.parseInt(stringTokenizer.nextToken());
    	m = Integer.parseInt(stringTokenizer.nextToken());
    	
    	parent = new int[n + 1];
    	rank = new int[n + 1];
    	
    	for (int i = 0; i <= n; i++) {
    		parent[i] = i;
    		rank[i] = 0;
    	}
    	
    	for (int i = 0; i < m; i++) {
    		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    		
    		int command = Integer.parseInt(stringTokenizer.nextToken());
    		int a = Integer.parseInt(stringTokenizer.nextToken());
    		int b = Integer.parseInt(stringTokenizer.nextToken());
    		
    		if (command == 0) {
    			union(a, b);
    		} else {
    			stringBuilder.append(find(a) == find(b) ? "YES" : "NO").append("\n");
    		}
    	}
    	
    	System.out.print(stringBuilder);
    }
    
    private static void union(int num1, int num2) {
    	int rootA = find(num1);
    	int rootB = find(num2);
    	
    	if (rootA == rootB) return;
    	
    	if (rank[rootA] < rank[rootB]) {
    		parent[rootA] = rootB;
    	} else if (rank[rootA] > rank[rootB]) {
    		parent[rootB] = rootA;
    	} else {
    		parent[rootB] = rootA;
    		rank[rootA]++;
    	}
    }
     
    private static int find(int num) {
    	if (parent[num] != num) {
    		parent[num] = find(parent[num]);
    	}
    	return parent[num];
    }
}
