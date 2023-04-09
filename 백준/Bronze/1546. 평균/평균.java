import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        double score[] = new double[N];
        
        double sum = 0;
        
        for (int i = 0; i < N; i++) {
            score[i] = scanner.nextDouble();
        }
        
        Arrays.sort(score);
        
        for (int i = 0; i < N; i++) {
            sum += ((score[i] / score[N-1])*100);
        }
        
        System.out.println(sum / N);
        
        scanner.close();
    }
}