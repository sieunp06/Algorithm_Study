import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int[] chess = {1, 1, 2, 2, 2, 8};
        
        for (int i = 0; i < chess.length; i++) {
            int pieces = stdIn.nextInt();
            
            chess[i] -= pieces;
            System.out.println(chess[i]);
        }
    }
}