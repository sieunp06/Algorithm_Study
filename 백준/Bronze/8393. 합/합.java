import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bf.readLine());
        int total = 0;
        
        for (int i = 1; i <= n; i++) {
            total += i;
        }
        
        System.out.println(total);
    }
}