import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        String input = stdIn.next();
        int total = 0;
        
        for (int i = 0; i < N; i++) {
            total += input.charAt(i) - '0';
        }
        
        System.out.println(total);
    }
}