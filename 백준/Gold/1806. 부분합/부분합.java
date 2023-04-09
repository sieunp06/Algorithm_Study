import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        
        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        int arr_sum = 0;
        
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st1.nextToken());
            arr_sum += numbers[i];
        }
        
        int answer;
        
        if (S == 0 || S > arr_sum) {
        	answer = 0;
        } else {
        	answer = Integer.MAX_VALUE;
        	int len = 0;
        	int sum = 0;
        	int lt = 0;
        
        	for (int rt = 0; rt < N; rt++) {
            	sum += numbers[rt];
            	len++;
            	if (sum >= S) {
                	if (answer > len) {
                		answer = len;
                	}
            	}
            	while (sum >= S) {
                	sum -= numbers[lt++];
                	len--;
                	if (sum >= S) {
                    	if (answer > len) {
                        	answer = len;
                    	}
                	}
            	}
        	}
        }
        
        System.out.println(answer);
        
        bf.close();
    }
}