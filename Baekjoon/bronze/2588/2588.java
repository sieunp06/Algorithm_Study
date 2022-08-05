import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        
        int B1 = B / 100;
        int B2 = (B - B1 * 100) / 10;
        int B3 = B - B1 * 100 - B2 * 10;
        
        System.out.println(A * B3);
        System.out.println(A * B2);
        System.out.println(A * B1);
        System.out.println(A * B);
        
        scanner.close();
    }
}