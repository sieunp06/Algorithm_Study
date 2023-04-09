import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(bf.readLine());
        
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(bf.readLine());
            
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            sb.append("Case #").append(i).append(": ").append(A + B).append('\n');
        }
        
        System.out.print(sb);
    }
}