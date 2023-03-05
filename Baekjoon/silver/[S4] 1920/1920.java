import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int Search(int[] A, int num) {
		int lt = 0; int rt = A.length - 1;
		int mid;
		
		while (lt <= rt) {
			mid = (lt + rt) / 2;
			if (A[mid] == num) return 1;
			else if (A[mid] < num) lt = mid + 1;
			else rt = mid - 1;
		}
		return 0;
	}
    public static void main(String[] args) throws IOException {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
    	
        int N = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        int[] A = new int[N];
        
        for (int i = 0; i < N; i++)
        	A[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(A);

        
        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        int[] B = new int[M];
        
        for (int i = 0; i < M; i++)
        	B[i] = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < M; i++)
        	System.out.println(Search(A, B[i]));
    }
}