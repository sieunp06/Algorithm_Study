import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //테스트 케이스 개수
        int N = scanner.nextInt();
        String str_arr[] = new String[N];
        
        for (int i = 0; i < N; i++) {
            str_arr[i] = scanner.next();
        }
            
        for (int i = 0; i < N; i++) {
            int score = 0;
            int count = 0;

            for (int j = 0; j < str_arr[i].length(); j++) {
                if (str_arr[i].charAt(j) == 'O') {
                    count += 1;
                }
                else {
                    count = 0;
                }
                score += count;
            }
            System.out.println(score);
            
            scanner.close();
        }
    }
}