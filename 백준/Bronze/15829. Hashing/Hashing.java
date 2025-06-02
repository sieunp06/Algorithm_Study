import java.io.*;
import java.util.*;

public class Main {
    private static int L;
    private static String input;

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int L = Integer.parseInt(bufferedReader.readLine());
        String input = bufferedReader.readLine();

        long total = 0;
        int idx = 0;
        for (char alpha : input.toCharArray()) {
            total += (Math.pow(31, idx) * (alpha - 'a' + 1)) % 1234567891;
            idx++;
        }

        System.out.println(total);
    }
}
