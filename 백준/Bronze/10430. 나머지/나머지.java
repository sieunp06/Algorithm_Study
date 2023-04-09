import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        sb.append((A + B) % C).append('\n');
        sb.append(((A % C) + (B % C)) % C).append('\n');
        sb.append((A * B) % C).append('\n');
        sb.append(((A % C) * (B % C)) % C);

        System.out.println(sb);
    }
}