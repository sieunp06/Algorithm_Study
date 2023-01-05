import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        int total = 0;
        boolean[][] square = new boolean[100][100];
        
        for (int i = 0; i < N; i++) {
            int x = stdIn.nextInt();
            int y = stdIn.nextInt();
            
            for (int j = x - 1; j < x + 9; j++) {
                for (int k = y - 1; k < y + 9; k++) {
                    if (!square[j][k])
                        square[j][k] = true;
                }
            }
        }
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (square[i][j])
                    total++;
            }
        }
        
        System.out.println(total);
    }
}