import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        int[] numbers = new int[N];
        
        for (int i = 0; i < N; i++) {
            numbers[i] = stdIn.nextInt();
        }
        
        int find = stdIn.nextInt();
        
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            if (numbers[i] == find)
                count++;
        }
        System.out.println(count);
    }
}