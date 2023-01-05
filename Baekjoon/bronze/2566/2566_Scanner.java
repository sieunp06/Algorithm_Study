import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int[][] nums = new int[9][9];
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                nums[i][j] = stdIn.nextInt();
            }
        }
        
        int max = nums[0][0];
        int ind_y = 0;
        int ind_x = 0;
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (max < nums[i][j]) {
                    max = nums[i][j];
                    ind_y = i;
                    ind_x = j;
                }
            }
        }
        
        System.out.println(max);
        System.out.println((ind_y + 1) + " " + (ind_x + 1));
    }
}