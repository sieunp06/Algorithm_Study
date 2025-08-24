import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;
    
    private static int n, m;
    private static int[] parents, rank;
    private static int[] trip;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	int root = find(trip[0]);
    	for (int num : trip) {
    		if (root != find(num)) {
    			System.out.println("NO");
    			return;
    		}
    	}
    	System.out.println("YES");
    }
    
    private static void init() throws NumberFormatException, IOException {
    	n = Integer.parseInt(bufferedReader.readLine());
    	m = Integer.parseInt(bufferedReader.readLine());
    	
    	parents = new int[n + 1];
    	rank = new int[n + 1];
    	trip = new int[m];
    	
    	for (int i = 1; i <= n; i++) {
    		parents[i] = i;
    		rank[i] = 0;
    	}
    	
    	for (int i = 1; i <= n; i++) {
    		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    		
    		for (int j = 1; j <= n; j++) {
    			int status = Integer.parseInt(stringTokenizer.nextToken());
    			
    			if (status == 1) {
    				union(i, j);
    			}
    		}
    	}
    	
    	stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    	for (int i = 0; i < m; i++) {
    		trip[i] = Integer.parseInt(stringTokenizer.nextToken());
    	}
    }
    
    private static void union(int num1, int num2) {
    	int ra = find(num1);
    	int rb = find(num2);
    	
    	if (ra == rb) return;
    	
    	if (rank[ra] < rank[rb]) {
    		parents[ra] = rb;
    	} else if (rank[ra] > rank[rb]) {
    		parents[rb] = ra;
    	} else {
    		parents[rb] = ra;
    		rank[ra]++;
    	}
    }
    
    private static int find(int num) {
    	if (parents[num] != num) {
    		parents[num] = find(parents[num]);
    	}
    	return parents[num];    	
    }
}
