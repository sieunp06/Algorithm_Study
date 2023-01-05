import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        int[] nums = new int[N];
        
        for (int i = 0; i < N; i++) {
            nums[i] = stdIn.nextInt();
        }    
        
        Arrays.sort(nums);
        
        for (int i = 0; i < N; i++) {
            System.out.println(nums[i]);
        }
    }
}