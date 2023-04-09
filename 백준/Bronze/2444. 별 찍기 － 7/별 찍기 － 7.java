import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());

        for(int i = 1; i <= N ; i++) {
            for(int j = 0; j < N-i; j++)
                sb.append(" ");
            for(int j = 0; j < i*2-1; j++)
                sb.append("*");
            sb.append('\n');
        }

        for(int i = N-1; i >= 0 ; i--) {
            for(int j = 0; j < N-i; j++)
                sb.append(" ");
            for(int j = 0; j < i*2-1; j++)
                sb.append("*");
            sb.append('\n');
        }

        System.out.println(sb);
    }
}