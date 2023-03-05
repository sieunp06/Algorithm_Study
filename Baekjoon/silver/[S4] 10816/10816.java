import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int Search_up(int[] A, int num) {
		int lt = 0; int rt = A.length;
		int mid;
		
		while (lt < rt) {
			mid = (lt + rt) / 2;
			
			if (num <= A[mid]) {
				rt = mid;
			}
	 
			else {
				lt = mid + 1;
			}
		}
		
		return lt;
	}
	
	public static int Search_down(int[] A, int num) {
		int lt = 0; int rt = A.length;
		int mid;
		
		while (lt < rt) {
			mid = (lt + rt) / 2;
			
			if (num < A[mid]) {
				rt = mid;
			}
	 
			else {
				lt = mid + 1;
			}
		}
		
		return lt;
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	
    	int N = Integer.parseInt(bf.readLine());
    	int[] A = new int[N];
    	
    	st = new StringTokenizer(bf.readLine());
    	for (int i = 0; i < N; i++) 
    		A[i] = Integer.parseInt(st.nextToken());
    	
    	Arrays.sort(A);
    	
    	int M = Integer.parseInt(bf.readLine());
    	
    	int[] B = new int[N];
    	
    	st = new StringTokenizer(bf.readLine());
    	for (int i = 0; i < M; i++) 
    		B[i] = Integer.parseInt(st.nextToken());
    	
    	
    	for (int i = 0; i < M; i++)
    		sb.append(Search_down(A, B[i]) - Search_up(A, B[i])).append(' ');
    	
    	System.out.println(sb);
    }
}