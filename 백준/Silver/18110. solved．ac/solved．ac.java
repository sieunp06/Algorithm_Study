import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());

        if (N == 0) {
            System.out.println(0);
            return;
        }

        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(scores);
        int cut = (int) Math.round(N * 0.15);

        long sum = 0;
        for (int i = cut; i < N - cut; i++) {
            sum += scores[i];
        }

        int count = N - (cut * 2);
        System.out.println(Math.round((double) sum / count));
    }
}
