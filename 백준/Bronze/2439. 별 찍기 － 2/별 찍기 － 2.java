import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int num = Integer.parseInt(bf.readLine());
        
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < num - i; j++) {
                sb.append(' ');
            }
            for (int k = 0; k < i; k++) {
                sb.append('*');
            }
            sb.append('\n');
        }
        
        System.out.println(sb);
    }
}