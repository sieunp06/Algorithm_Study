import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        String name = stdIn.next();
        int score = 0;
        
        for (int i = 0; i < N; i++) {
            score += (int)name.charAt(i) - 64;
        }
        
        System.out.println(score);
    }
}