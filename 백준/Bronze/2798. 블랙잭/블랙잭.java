import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main (String[] args) throws IOException { 
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        
        st = new StringTokenizer(bf.readLine());
        
        for (int i = 0; i < N; i++) 
        	arr[i] = Integer.parseInt(st.nextToken());
        
        int answer = 0;
        
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
        		for (int k = 0; k < N; k++) {
        			if (i != j && j != k && i != k) {
        				int total = arr[i] + arr[j] + arr[k];
        				
        				if (total <= M) {
        					if (M - total < M - answer) 
        						answer = total;
        				}
        			}
        		}
        	}
        }
        
        System.out.println(answer);
    }
}