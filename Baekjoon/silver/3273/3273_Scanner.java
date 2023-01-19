import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        int[] numbers = new int[N];
        
        for (int  i = 0; i < N; i++) 
            numbers[i] = stdIn.nextInt();
        Arrays.sort(numbers);
        
        int x = stdIn.nextInt();
        
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
    }
}