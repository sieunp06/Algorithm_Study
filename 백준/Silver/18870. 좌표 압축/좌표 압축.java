import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        int[] sorted = new int[N];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        for (int i = 0; i < N; i++) {
        	String input = st.nextToken();
        	sorted[i] = arr[i] = Integer.parseInt(input);
        }
        
        Arrays.sort(sorted);
        
        int rank = 0;
        
        for (int x: sorted) {
        	if (!map.containsKey(x)) {
        		map.put(x, rank);
        		rank++;
        	}
        }

        StringBuilder sb = new StringBuilder();
        
        for (int x: arr) {
        	sb.append(map.get(x)).append(' ');
        }
        
        System.out.println(sb);
	}
}