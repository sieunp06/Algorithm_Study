import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bf.readLine());
        
        int answer = 0;
        
        ArrayList<Integer> number = new ArrayList<>();
        
        int[] isPrime = new int[N + 1];
        
        for (int i = 2; i <= N; i++) {
        	if (isPrime[i] == 0) {
        		number.add(i);
        		for (int j = i; j <= N; j = j + i) {
        			isPrime[j] = 1;
        		}
        	}
        }
        
        int sum = 0;
        int lt = 0;
        
        for (int rt = 0; rt < N; rt++) {
        	if (rt == number.size()) break;
        	sum += number.get(rt);
        	if (sum == N) answer++;
        	while (sum >= N) {
        		sum -= number.get(lt++);
        		if (sum == N) {
        			answer++;
        		}
        	}
        }
        
        System.out.println(answer);
        bf.close();
    }
}