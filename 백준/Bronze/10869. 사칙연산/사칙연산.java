import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        sb.append(A + B).append('\n');
        sb.append(A - B).append('\n');
        sb.append(A * B).append('\n');
        sb.append(A / B).append('\n');
        sb.append(A % B).append('\n');
        
        System.out.println(sb);
    }
}