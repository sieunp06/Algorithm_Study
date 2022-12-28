import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int[] numbers = new int[30];
        
        for (int i = 0; i < 28; i++) {
            int num = stdIn.nextInt();
            numbers[num - 1] = 1;
        }
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 1)
                System.out.println(i + 1);
        }
    }
}