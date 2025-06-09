import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        String isbn = bufferedReader.readLine();
        int missingIndex = -1;
        int sum = 0;

        for (int i = 0; i < 13; i++) {
            if (isbn.charAt(i) == '*') {
                missingIndex = i;
                continue;
            }

            int digit = isbn.charAt(i) - '0';
            sum += (i % 2 == 0) ? digit : 3 * digit;
        }

        for (int x = 0; x <= 9; x++) {
            int tempSum = sum + ((missingIndex % 2 == 0) ? x : 3 * x);
            if (tempSum % 10 == 0) {
                System.out.println(x);
                return;
            }
        }
    }
}
