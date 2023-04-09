import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int A = Integer.parseInt(bf.readLine());
        int B = Integer.parseInt(bf.readLine());
        
        int B1 = B / 100;
        int B2 = (B - B1 * 100) / 10;
        int B3 = B - B1 * 100 - B2 * 10;

        sb.append(A * B3).append('\n');
        sb.append(A * B2).append('\n');
        sb.append(A * B1).append('\n');
        sb.append(A * B);

        System.out.println(sb);
    }
}