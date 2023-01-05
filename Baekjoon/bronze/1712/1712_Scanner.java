import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int A = stdIn.nextInt();
        int B = stdIn.nextInt();
        int C = stdIn.nextInt();
        
        int count;
        
        if (B >= C) {
            count = -1;
        } else 
            count = (A / (C - B)) + 1;
        
        System.out.println(count);
    }
}