import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        
        int arr[] = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        
        for (int j = 0; j < N; j++) {
            if (arr[j] < X) {
                System.out.print(arr[j] + " ");
            }
        }
    }
}