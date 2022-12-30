import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        
        for (int i = 0; i < N; i++) {
            int S = stdIn.nextInt();
            int[] scores = new int[S];
            double total = 0;
            double count = 0;
            for (int j = 0; j < S; j++) {
                int score = stdIn.nextInt();
                scores[j] = score;
                total += score;
            }
            double Avg = total / S;
            
            for (int x : scores) {
                if (x > Avg) {
                    count ++;
                }
            }
            System.out.printf("%.3f%%\n",(count/S)*100);
        }
    }
}