import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int A = stdIn.nextInt();
        int B = stdIn.nextInt();
        
        int[][] num1 = new int[A][B];
        
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                num1[i][j] = stdIn.nextInt();
            }
        }
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                num1[i][j] += stdIn.nextInt();
            }
        }
        
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                System.out.print(num1[i][j]);
                if (j != B - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}