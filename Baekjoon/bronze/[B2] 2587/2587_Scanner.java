import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int[] nums = new int[5];
        int total = 0;
        int avg;
        int mid;
        
        for (int i = 0; i < 5; i++) {
            nums[i] = stdIn.nextInt();
            total += nums[i];
        }

        Arrays.sort(nums);
        
        avg = total / 5;    
        mid = nums[2];
        
        System.out.println(avg);
        System.out.println(mid);
    }
}