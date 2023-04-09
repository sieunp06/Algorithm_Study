import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        
        int total = A * B * C;
        String total_st = Integer.toString(total);
        
        for (int i = 0; i < 10; i++) {
            int count = 0;
            for (int j = 0; j < total_st.length(); j++) {
                if ((total_st.charAt(j) - '0') == i) 
                    count++;
            }
            System.out.println(count);
        }
        
        scanner.close();
    }
}