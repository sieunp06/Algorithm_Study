import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int cycle = 0;
        
        int N = scanner.nextInt();
        int num = N;
        
        while (true) {
            int left = N / 10;
            int right = N % 10;
            int sum = left + right;
            
            cycle ++;
            
            N = right * 10 + sum % 10;
            
            if (N == num) 
                break;        
        }
        
        System.out.println(cycle);
        scanner.close();
    }
}