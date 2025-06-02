import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int L = Integer.parseInt(bufferedReader.readLine());
        String input = bufferedReader.readLine();

        final int r = 31;
        final int M = 1234567891;

        long total = 0;
        long pow = 1;
        for (int i = 0; i < L; i++) {
            int value = input.charAt(i) - 'a' + 1;
            total = (total + (value * pow) % M) % M;
            pow = (pow * r) % M;
        }

        System.out.println(total);
    }
}
