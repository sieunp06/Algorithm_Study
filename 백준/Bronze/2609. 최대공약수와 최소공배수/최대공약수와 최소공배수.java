import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int max = 0;
        for (int i = 1; i <= N && i <= M; i++) {
            if (N % i == 0 && M % i == 0) {
                if (max < i) {
                    max = i;
                }
            }
        }
        
        System.out.println(max);
        System.out.println(N * M / max);
    }
}