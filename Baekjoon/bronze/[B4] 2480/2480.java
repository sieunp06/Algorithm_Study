import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int a = stdIn.nextInt();
        int b = stdIn.nextInt();
        int c = stdIn.nextInt();
        
        if (a == b && b == c && a == c) 
            System.out.println(10000 + a * 1000);
        else if (a == b)
            System.out.println(1000 + a * 100);
        else if (b == c)
            System.out.println(1000 + b * 100);
        else if (a == c)
            System.out.println(1000 + a * 100);
        else 
            System.out.println(Math.max(a, Math.max(b, c)) * 100);
    }
}