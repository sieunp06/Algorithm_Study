import java.io.*;
import java.util.*;

public class Main {
    static String[] inputs = new String[3];

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            init();
        }
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int H = Integer.parseInt(stringTokenizer.nextToken());
        int W = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        if(N % H == 0) {
            System.out.println((H * 100) + (N / H));

        } else {
            System.out.println(((N % H) * 100) + ((N / H) + 1));
        }
    }
}
