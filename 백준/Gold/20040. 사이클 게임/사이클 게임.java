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
    private static int answer = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    	
    	n = Integer.parseInt(stringTokenizer.nextToken());
    	m = Integer.parseInt(stringTokenizer.nextToken());
    	
    	parents = new int[n];
    	rank = new int[n];
    	
    	for (int i = 0; i < n; i++) {
    		parents[i] = i;
    		rank[i] = 0;
    	}
    	
    	for (int i = 1; i <= m; i++) {
    		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    		
    		int a = Integer.parseInt(stringTokenizer.nextToken());
    		int b = Integer.parseInt(stringTokenizer.nextToken());
    		
    		if (!union(a, b)) {
    			answer = i;
    			break;
    		}
    	}
    	
    	System.out.println(answer);
    }
    
    private static boolean union(int num1, int num2) {
    	int ra = find(num1);
    	int rb = find(num2);
    	
    	if (ra == rb) return false;
    	
    	if (rank[ra] < rank[rb]) {
    		parents[ra] = rb;
    	} else if (rank[ra] > rank[rb]) {
    		parents[rb] = ra;
    	} else {
    		parents[rb] = ra;
    		rank[ra]++;
    	}
    	return true;
    }
    
    private static int find(int num) {
    	if (parents[num] == num) return num;
    	return parents[num] = find(parents[num]);
    }
}