import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        int k = stdIn.nextInt();
        
        int[] scores = new int[N];
        
        for (int i = 0; i < N; i++) {
            scores[i] = stdIn.nextInt();
        }
        
        Arrays.sort(scores);
        
        System.out.println(scores[N - k]);
    }
}