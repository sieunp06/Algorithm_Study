import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int total = stdIn.nextInt();
        int N = stdIn.nextInt();
        
        for (int i = 0; i < N; i++) {
            int price = stdIn.nextInt();
            int number = stdIn.nextInt();
            
            total -= price * number;
        }
        
        if (total == 0) 
            System.out.println("Yes");
        else 
            System.out.println("No");
    }
}