import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bf.readLine());
        int[] numbers = new int[N];
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        
        int x = Integer.parseInt(bf.readLine());
        
        int answer = 0;
        int sum;
        int lt = 0;
        int rt = N - 1;
        
        while (lt < rt) {
            sum = numbers[lt] + numbers[rt];
            if (sum == x) answer++;
            if (sum <= x) lt++;
            else rt--;
        }
        System.out.println(answer);
        
        bf.close();
    }
}
