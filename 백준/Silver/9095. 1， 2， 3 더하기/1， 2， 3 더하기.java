import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int target = Integer.parseInt(bufferedReader.readLine());
            int[] num = new int[12];

            num[0] = 1;
            num[1] = 1;
            num[2] = 2;
            num[3] = 4;

            for (int i = 4; i <= 11; i++) {
                num[i] = num[i - 3] + num[i - 2] + num[i - 1];
            }

            stringBuilder.append(num[target]).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
