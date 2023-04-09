import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int[] num = new int[9];
        
        for (int i = 0; i < 9; i++) 
            num[i] = Integer.parseInt(bf.readLine());
        
        int max = num[0];
        int index = 0;

        for (int i = 1; i < 9; i++) {
            if (max < num[i]) {
                max = num[i];
                index = i;
            }
        }
        
        System.out.println(max);
        System.out.println(index + 1);
    }
}