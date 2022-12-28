import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bf.readLine());
        
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        int num = Integer.parseInt(bf.readLine());
        int count = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            if (num == numbers[i])
                count ++;
        }
        
        System.out.println(count);
    }
}