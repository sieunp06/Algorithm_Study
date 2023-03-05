import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int bytes = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        
        bytes -= 4;
        while (bytes != 0) {
            sb.append("long ");
            bytes -= 4;
        }
        
        sb.append("long int");
        
        System.out.println(sb);
    }
}