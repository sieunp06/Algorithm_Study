import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] count = new int[10001];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            count[num]++;
        }

        for (int i = 1; i <= 10000; i++) {
            while (count[i]-- > 0) {
                stringBuilder.append(i).append("\n");
            }
        }

        System.out.print(stringBuilder);
    }
}
