import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int num = Integer.parseInt(bf.readLine());
        
        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                sb.append('*');    
            }
            sb.append('\n');
        }
        
        System.out.println(sb);
    }
}