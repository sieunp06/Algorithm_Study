import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int arr[] = new int[9];
        
        int num = arr[0];
        int index = 0;
        
        for (int i = 0; i < 9; i++) {
            arr[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < 9; i++) {
            if (arr[i] > num) {
                index = i + 1;
                num = arr[i];
            }
        }
        
        System.out.println(num);
        System.out.println(index);
        
        scanner.close();
    }
}