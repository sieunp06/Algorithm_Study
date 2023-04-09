import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(bf.readLine());
        int[] numbers = new int[N];
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(numbers);
    
        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        int total;
        int abs;
        int lt = 0;
        int rt = N - 1;
    
        while (lt < rt) {
            total = numbers[rt] + numbers[lt];
            abs = Math.abs(total);
            if (min > abs) {
                min = abs;
                answer[0] = numbers[lt];
                answer[1] = numbers[rt];
            } 
            if (total < 0) lt++;
            else rt--;
        }
    
        System.out.print(answer[0] + " " + answer[1]);
        bf.close();
    }
}